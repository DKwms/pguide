package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.cache.CacheNameGenerator;
import com.zyc.download4j.core.concept.Part;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.write.DownloadWriter;
import com.zyc.download4j.core.write.Progress;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Collection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link SourceCompressor} 的抽象类，对缓存做了处理。
 */
public abstract class AbstractSourceCompressor<OS extends OutputStream> implements SourceCompressor {

    @SneakyThrows
    @Override
    public Compression compress(Source source, DownloadWriter writer, DownloadContext context) {
        String cachePath = context.getOptions().getCompressCachePath();
        String cacheName = getCacheName(source, context);
        boolean cacheEnable = context.getOptions().isCompressCacheEnabled();
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        //是否启用缓存
        if (cacheEnable) {
            File dir = new File(cachePath);
            if (!dir.exists()) {
                boolean mkdirs = dir.mkdirs();
            }
            File cache = new File(dir, cacheName);
            //缓存是否存在
            if (cache.exists()) {
                publisher.publish(new SourceCompressedCacheUsedEvent(context, source, cache.getAbsolutePath()));
            } else {
                publisher.publish(new SourceFileCompressionEvent(context, source, cache));
                //写入缓存文件
                try (FileOutputStream fos = new FileOutputStream(cache)) {
                    doCompress(source, fos, writer, context);
                }
            }
            FileCompression compression = new FileCompression(cache);
            compression.setContentType(getContentType());
            return compression;
        } else {
            //在内存中压缩
            publisher.publish(new SourceMemoryCompressionEvent(context, source));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            doCompress(source, os, writer, context);
            MemoryCompression compression = new MemoryCompression(os.toByteArray());
            compression.setName(cacheName);
            compression.setContentType(getContentType());
            return compression;
        }
    }

    @SneakyThrows
    public void doCompress(Source source, OutputStream os, DownloadWriter writer, DownloadContext context) {
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new SourceCompressionFormatEvent(context, source, getFormat()));
        try (OS nos = newOutputStream(os, source, context)) {
            Progress progress = new Progress(source.getLength());
            Collection<Part> parts = source.getParts();
            for (Part part : parts) {
                InputStream is = part.getInputStream();
                beforeWrite(part, nos);
                writer.write(is, nos, null, part.getCharset(), part.getLength(), (current, increase) -> {
                    progress.update(increase);
                    publisher.publish(new SourceCompressingProgressEvent(context, progress.freeze()));
                });
                afterWrite(part, nos);
            }
        }
    }

    public abstract OS newOutputStream(OutputStream os, Source source, DownloadContext context);

    public abstract void beforeWrite(Part part, OS os);

    public abstract void afterWrite(Part part, OS os);

    public String getCacheName(Source source, DownloadContext context) {
        String compressCacheName = context.getOptions().getCompressCacheName();
        String suffix = getSuffix();
        String nameToUse;
        if (StringUtils.hasText(compressCacheName)) {
            nameToUse = compressCacheName;
        } else {
            CacheNameGenerator generator = context.get(CacheNameGenerator.class);
            nameToUse = generator.generate(source, context);
        }
        if (!StringUtils.hasText(nameToUse)) {
            throw new DownloadException("Cache name is null or empty");
        }
        if (nameToUse.endsWith(suffix)) {
            return nameToUse;
        }
        int index = nameToUse.lastIndexOf(CompressFormat.DOT);
        if (index == -1) {
            return nameToUse + suffix;
        } else {
            return nameToUse.substring(0, index) + suffix;
        }
    }

    public abstract String getSuffix();

    public abstract String getContentType();
}
