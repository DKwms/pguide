package com.zyc.download4j.core.handler.impl;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.handler.DownloadHandler;
import com.zyc.download4j.core.handler.DownloadHandlerChain;
import com.zyc.download4j.core.load.AfterSourceLoadedEvent;
import com.zyc.download4j.core.load.SourceLoader;
import com.zyc.download4j.core.source.Source;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 对所有的 {@link Source} 进行加载。
 */
@AllArgsConstructor
public class LoadSourceHandler implements DownloadHandler {

    private SourceLoader sourceLoader;

    @Override
    public Mono<Void> handle(DownloadContext context, DownloadHandlerChain chain) {
        Source source = context.get(Source.class);
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        return sourceLoader.load(source, context)
                .doOnSuccess(it -> publisher.publish(new AfterSourceLoadedEvent(context, it)))
                .flatMap(it -> {
                    context.set(Source.class, it);
                    return chain.next(context);
                });
    }

    @Override
    public int getOrder() {
        return ORDER_LOAD_SOURCE;
    }
}
