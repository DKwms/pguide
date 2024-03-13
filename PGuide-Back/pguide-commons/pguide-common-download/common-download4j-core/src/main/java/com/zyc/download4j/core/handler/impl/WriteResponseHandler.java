package com.zyc.download4j.core.handler.impl;

import com.zyc.download4j.core.compress.Compression;
import com.zyc.download4j.core.concept.Part;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.context.DownloadContextInitializer;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.handler.DownloadHandler;
import com.zyc.download4j.core.handler.DownloadHandlerChain;
import com.zyc.download4j.core.web.*;
import com.zyc.download4j.core.write.DownloadWriter;
import com.zyc.download4j.core.write.DownloadWriterAdapter;
import com.zyc.download4j.core.write.Progress;
import com.zyc.download4j.core.web.*;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 将 {@link Compression} 写入到 {@link DownloadResponse}。
 */
@AllArgsConstructor
public class WriteResponseHandler implements DownloadHandler, DownloadContextInitializer {

    private DownloadWriterAdapter downloadWriterAdapter;

    private DownloadRequestProvider downloadRequestProvider;

    private DownloadResponseProvider downloadResponseProvider;

    @Override
    public Mono<Void> handle(DownloadContext context, DownloadHandlerChain chain) {
        Compression compression = context.get(Compression.class);
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        //获得Request
        return downloadRequestProvider.getRequest(context).flatMap(request -> {
                    //获得Range
                    Range range = request.getRange();
                    DownloadWriter writer = downloadWriterAdapter.getWriter(compression, range, context);
                    //获得Response
                    return downloadResponseProvider.getResponse(context)
                            //设置响应头
                            .filter(response -> applyHeaders(response, compression, range, context))
                            //写数据
                            .flatMap(response -> response.write(os -> {
                                Collection<Part> parts = compression.getParts();
                                Progress progress = new Progress(compression.getLength());
                                for (Part part : parts) {
                                    InputStream is = part.getInputStream();
                                    writer.write(is, os, range, part.getCharset(), part.getLength(), (current, increase) -> {
                                        //更新并发布写入进度
                                        progress.update(increase);
                                        publisher.publish(new ResponseWritingProgressEvent(context, progress.freeze()));
                                    });
                                }
                                try {
                                    os.flush();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }));
                })
                .doOnSuccess(it -> publisher.publish(new AfterResponseWrittenEvent(context)));
    }

    public boolean applyHeaders(DownloadResponse response, Compression compression, Range range, DownloadContext context) {
        //Range处理
        response.setBytesAcceptRanges();
        Long length = compression.getLength();
        if (range == null || length == null || length <= 0) {
            response.setContentLength(length);
        } else {
            if (range.isSupport()) {
                response.setStatusCode(206);
                if (range.hasStart() && range.hasEnd()) {
                    long l = range.getEnd() - range.getStart() + 1;
                    range.setLength(l);
                    response.setContentLength(l);
                    response.setContentRange(range.getStart(), range.getEnd(), length);
                } else if (range.hasStart()) {
                    long l = length - range.getStart();
                    range.setLength(l);
                    response.setContentLength(l);
                    response.setContentRange(range.getStart(), length - 1, length);
                } else if (range.hasEnd()) {
                    long l = range.getEnd();
                    range.setLength(l);
                    response.setContentLength(l);
                    response.setContentRange(length - range.getEnd(), length - 1, length);
                } else {
                    long l = length;
                    range.setLength(l);
                    response.setContentLength(l);
                    response.setContentRange(0, length - 1, length);
                }
            } else {
                response.setStatusCode(416);
                return false;
            }
        }

        //inline / attachment
        boolean inline = context.getOptions().isInline();
        String filename = context.getOptions().getFilename();
        String filenameToUse;
        if (StringUtils.hasText(filename)) {
            filenameToUse = filename;
        } else {
            filenameToUse = compression.getName();
        }
        if (inline) {
            response.setInline(filenameToUse);
        } else {
            response.setAttachment(filenameToUse);
        }

        //ContentType
        String contentType = context.getOptions().getContentType();
        if (StringUtils.hasText(contentType)) {
            response.setContentType(contentType);
        } else {
            String compressionContentType = compression.getContentType();
            if (compressionContentType == null || compressionContentType.isEmpty()) {
                response.setContentType(ContentType.Application.OCTET_STREAM);
            } else {
                response.setContentType(compressionContentType);
            }
        }

        //Headers
        Map<String, String> headers = context.getOptions().getHeaders();
        if (headers != null) {
            response.setHeaders(headers);
        }

        return true;
    }

    @Override
    public void initialize(DownloadContext context) {
        context.set(DownloadWriterAdapter.class, downloadWriterAdapter);
        context.set(DownloadRequestProvider.class, downloadRequestProvider);
        context.set(DownloadResponseProvider.class, downloadResponseProvider);
    }

    @Override
    public int getOrder() {
        return ORDER_WRITE_RESPONSE;
    }
}
