package com.zyc.download4j.core.web.servlet;

import com.zyc.download4j.core.concept.DownloadReturnInterceptor;
import com.zyc.download4j.core.exception.ErrorHolder;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 基于 Servlet 的返回拦截，用于 webmvc。
 */
public class ServletDownloadReturnInterceptor implements DownloadReturnInterceptor {

    @Override
    public Object intercept(Mono<Void> mono) {
        ErrorHolder holder = new ErrorHolder();
        mono.subscribe(unused -> {
        }, holder::set);
        holder.throwIfError();
        return null;
    }
}
