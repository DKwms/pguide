package com.zyc.download4j.core.web.reactive;

import com.zyc.download4j.core.concept.DownloadReturnInterceptor;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 基于 Reactive 的返回拦截，用于 webflux。
 */
public class ReactiveDownloadReturnInterceptor implements DownloadReturnInterceptor {

    @Override
    public Object intercept(Mono<Void> mono) {
        return mono;
    }
}
