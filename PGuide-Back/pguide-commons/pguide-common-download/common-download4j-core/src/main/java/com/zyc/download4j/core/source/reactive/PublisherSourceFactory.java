package com.zyc.download4j.core.source.reactive;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import org.reactivestreams.Publisher;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配 {@link Publisher} 对象的 {@link SourceFactory}。
 */
public class PublisherSourceFactory implements SourceFactory {

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source instanceof Publisher;
    }

    @Override
    public Source create(Object source, DownloadContext context) {
        return new PublisherSource((Publisher<?>) source);
    }
}
