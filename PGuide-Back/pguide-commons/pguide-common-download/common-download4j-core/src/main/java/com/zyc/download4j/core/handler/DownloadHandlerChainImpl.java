package com.zyc.download4j.core.handler;

import com.zyc.download4j.core.context.DownloadContext;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadHandlerChain} 的默认实现。
 */
@AllArgsConstructor
public class DownloadHandlerChainImpl implements DownloadHandlerChain {

    private int index;

    private final List<DownloadHandler> handlers;

    @Override
    public Mono<Void> next(DownloadContext context) {
        if (index < handlers.size()) {
            DownloadHandler handler = handlers.get(index);
            DownloadHandlerChain chain = new DownloadHandlerChainImpl(index + 1, handlers);
            return handler.handle(context, chain);
        } else {
            return Mono.empty();
        }
    }
}
