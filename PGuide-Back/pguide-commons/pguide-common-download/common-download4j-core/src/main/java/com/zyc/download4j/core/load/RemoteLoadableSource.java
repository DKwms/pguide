package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.write.DownloadWriter;
import com.zyc.download4j.core.write.DownloadWriterAdapter;
import com.zyc.download4j.core.write.Progress;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 支持网络加载的 {@link Source}。
 */
public abstract class RemoteLoadableSource extends AbstractLoadableSource {

    @Override
    public Mono<Source> doLoad(OutputStream os, DownloadContext context) {
        DownloadWriterAdapter writerAdapter = context.get(DownloadWriterAdapter.class);
        DownloadWriter writer = writerAdapter.getWriter(this, null, context);
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        return loadRemote(context).map(it -> {
            Progress progress = new Progress(length);
            writer.write(it, os, null, null, length, (current, increase) -> {
                progress.update(increase);
                publisher.publish(new SourceLoadingProgressEvent(context, this, progress.freeze()));
            });
            return this;
        });
    }

    public abstract Mono<InputStream> loadRemote(DownloadContext context);

    public static abstract class Builder<T extends RemoteLoadableSource, B extends Builder<T, B>> extends AbstractLoadableSource.Builder<T, B> {

        public Builder() {
            asyncLoad = true;
            cacheEnabled = true;
        }

        @Override
        protected T build(T target) {
            if (cacheEnabled && !StringUtils.hasText(cachePath)) {
                throw new DownloadException("Cache path is null or empty");
            }
            return super.build(target);
        }
    }
}
