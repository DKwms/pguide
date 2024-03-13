package com.zyc.download4j.core.handler.impl;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.context.DownloadContextDestroyer;
import com.zyc.download4j.core.context.DownloadContextInitializer;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.handler.DownloadHandler;
import com.zyc.download4j.core.handler.DownloadHandlerChain;
import com.zyc.download4j.core.source.*;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 将任意的对象解析成对应的 {@link Source}。
 */
@AllArgsConstructor
public class CreateSourceHandler implements DownloadHandler, DownloadContextInitializer, DownloadContextDestroyer {

    private SourceFactoryAdapter sourceFactoryAdapter;

    @Override
    public Mono<Void> handle(DownloadContext context, DownloadHandlerChain chain) {
        Object original = context.getOptions().getSource();
        SourceFactory factory = sourceFactoryAdapter.getFactory(original, context);
        Source source = factory.create(original, context);
        context.set(Source.class, source);
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new AfterSourceCreatedEvent(context, source));
        return chain.next(context);
    }

    @Override
    public void initialize(DownloadContext context) {
        context.set(SourceFactoryAdapter.class, sourceFactoryAdapter);
    }

    @Override
    public void destroy(DownloadContext context) {
        Source source = context.get(Source.class);
        if (source != null) {
            DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
            boolean delete = context.getOptions().isSourceCacheDelete();
            if (delete) {
                source.deleteCache();
                publisher.publish(new SourceCacheDeletedEvent(context, source));
            }
            source.release();
            publisher.publish(new SourceReleasedEvent(context, source));
        }
    }

    @Override
    public int getOrder() {
        return ORDER_CREATE_SOURCE;
    }
}
