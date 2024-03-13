package com.zyc.download4j.core.load;

import com.zyc.download4j.core.cache.CacheNameGenerator;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.source.AbstractSource;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.web.ContentType;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.io.*;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 支持预加载的 {@link Source}。
 */
@Getter
public abstract class AbstractLoadableSource extends AbstractSource {

    protected Long length;

    public boolean isAsyncLoad() {
        boolean asyncLoad = super.isAsyncLoad();
        if (asyncLoad && isCacheEnabled() && isCacheExisted()) {
            return false;
        }
        return asyncLoad;
    }

    @Override
    public boolean isCacheExisted() {
        return new File(getCachePath(), getName()).exists();
    }

    @SneakyThrows
    @Override
    public Mono<Source> load(DownloadContext context) {
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        if (inputStream != null) {
            publisher.publish(new SourceAlreadyLoadedEvent(context, this));
            return Mono.just(this);
        }
        if (isCacheEnabled()) {
            String cachePath = getCachePath();
            if (cachePath == null) {
                throw new DownloadException("Cache path is null");
            }
            File dir = new File(cachePath);
            if (!dir.exists()) {
                boolean mkdirs = dir.mkdirs();
            }
            CacheNameGenerator generator = context.get(CacheNameGenerator.class);
            String nameToUse = generator.generate(this, context);
            if (!StringUtils.hasText(nameToUse)) {
                throw new DownloadException("Cache name is null or empty");
            }

            File cache = new File(dir, nameToUse);
            Mono<Source> mono;
            if (cache.exists()) {
                //Event Publish
                publisher.publish(new SourceLoadedCacheUsedEvent(context, this, cache.getAbsolutePath()));
                mono = Mono.just(this);
            } else {
                FileOutputStream fos = new FileOutputStream(cache);
                mono = doLoad(fos, context)
                        .doOnSuccess(s -> closeStream(fos))
                        .doOnError(e -> closeStream(fos));
            }
            return mono.map(it -> {
                String contentType = getContentType();
                if (!StringUtils.hasText(contentType)) {
                    setContentType(ContentType.file(cache));
                }
                long l = cache.length();
                if (length == null) {
                    length = l;
                } else {
                    if (length != l) {
                        length = l;
                    }
                }
                inputStream = getCacheInputStream(cache);
                return it;
            });
        } else {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            return doLoad(os, context).map(it -> {
                byte[] bytes = os.toByteArray();
                long l = bytes.length;
                if (length == null) {
                    length = l;
                } else {
                    if (length != l) {
                        length = l;
                    }
                }
                inputStream = new ByteArrayInputStream(bytes);
                return it;
            });
        }
    }

    private void closeStream(OutputStream os) {
        try {
            os.close();
        } catch (IOException ignore) {
        }
    }

    @Override
    public InputStream openInputStream() {
        return inputStream;
    }

    @SneakyThrows
    public InputStream getCacheInputStream(File cache) {
        return new FileInputStream(cache);
    }

    @Override
    public void deleteCache() {
        if (isCacheEnabled()) {
            File file = new File(getCachePath(), getName());
            if (file.exists()) {
                boolean delete = file.delete();
            }
        }
    }

    public abstract Mono<Source> doLoad(OutputStream os, DownloadContext context);

    public static abstract class Builder<T extends AbstractLoadableSource, B extends Builder<T, B>>
            extends AbstractSource.Builder<T, B> {
        @Override
        protected T build(T target) {
            return super.build(target);
        }
    }
}
