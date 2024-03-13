package com.zyc.download4j.core.handler.impl;

import com.zyc.download4j.core.compress.*;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.context.DownloadContextDestroyer;
import com.zyc.download4j.core.context.DownloadContextInitializer;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.handler.DownloadHandler;
import com.zyc.download4j.core.handler.DownloadHandlerChain;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.write.DownloadWriter;
import com.zyc.download4j.core.write.DownloadWriterAdapter;
import com.zyc.download4j.core.compress.*;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 对 {@link Source} 进行压缩。
 */
@AllArgsConstructor
public class CompressSourceHandler implements DownloadHandler, DownloadContextInitializer, DownloadContextDestroyer {

    private SourceCompressorAdapter sourceCompressorAdapter;

    @Override
    public Mono<Void> handle(DownloadContext context, DownloadHandlerChain chain) {
        Source source = context.get(Source.class);
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        Compression compression;
        boolean single = source.isSingle();
        boolean forceCompress = context.getOptions().isForceCompress();
        //（单一文件 && 没有强制压缩），则不压缩
        if (single && !forceCompress) {
            compression = new NoCompression(source);
            publisher.publish(new SourceNoCompressionEvent(context, source));
        } else {
            String compressFormat = context.getOptions().getCompressFormat();
            String formatToUse = StringUtils.hasText(compressFormat) ? compressFormat : CompressFormat.ZIP;
            SourceCompressor compressor = sourceCompressorAdapter.getCompressor(formatToUse, context);
            DownloadWriterAdapter writerAdapter = context.get(DownloadWriterAdapter.class);
            DownloadWriter writer = writerAdapter.getWriter(source, null, context);
            compression = compressor.compress(source, writer, context);
        }
        publisher.publish(new AfterSourceCompressedEvent(context, source, compression));
        context.set(Compression.class, compression);
        return chain.next(context);
    }

    @Override
    public void initialize(DownloadContext context) {
        context.set(SourceCompressorAdapter.class, sourceCompressorAdapter);
    }

    @Override
    public void destroy(DownloadContext context) {
        Compression compression = context.get(Compression.class);
        if (compression != null) {
            DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
            boolean delete = context.getOptions().isCompressCacheDelete();
            if (delete) {
                compression.deleteCache();
                publisher.publish(new CompressionCacheDeletedEvent(context, compression));
            }
            compression.release();
            publisher.publish(new CompressionReleasedEvent(context, compression));
        }
    }

    @Override
    public int getOrder() {
        return ORDER_COMPRESS_SOURCE;
    }
}
