package com.zyc.download4j.core.concept;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.context.DownloadContextFactory;
import com.zyc.download4j.core.handler.DownloadHandler;
import com.zyc.download4j.core.handler.DownloadHandlerChain;
import com.zyc.download4j.core.handler.DownloadHandlerChainImpl;
import com.zyc.download4j.core.options.DownloadOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 基于 {@link DownloadHandlerChain} 的 {@link DownloadConcept} 实现。
 */
@Getter
@AllArgsConstructor
public class ChainDownloadConcept implements DownloadConcept {

    private final DownloadContextFactory contextFactory;

    private final DownloadReturnInterceptor returnInterceptor;

    private final List<DownloadHandler> handlers;

    @Override
    public Object download(DownloadOptions options) {
        DownloadContext context = contextFactory.create(options);
        context.initialize();

        Mono<Void> mono = new DownloadHandlerChainImpl(0, handlers)
                .next(context)
                .doAfterTerminate(context::destroy);

        return returnInterceptor.intercept(mono);
    }
}
