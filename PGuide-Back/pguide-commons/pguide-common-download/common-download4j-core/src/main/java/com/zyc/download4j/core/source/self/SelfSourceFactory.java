package com.zyc.download4j.core.source.self;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配 {@link Source} 的 {@link SourceFactory}。
 */
public class SelfSourceFactory implements SourceFactory {

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source instanceof Source;
    }

    @Override
    public Source create(Object source, DownloadContext context) {
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new SelfSourceCreatedEvent(context, (Source) source));
        return (Source) source;
    }
}
