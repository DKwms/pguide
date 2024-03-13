package com.zyc.download4j.core.concept;

import com.zyc.download4j.core.web.reactive.ReactiveDownloadReturnInterceptor;
import com.zyc.download4j.core.web.servlet.ServletDownloadReturnInterceptor;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载返回拦截器。
 * 主要用于兼容 webmvc 和 webflux 的返回值处理
 *
 * @see ServletDownloadReturnInterceptor
 * @see ReactiveDownloadReturnInterceptor
 */
public interface DownloadReturnInterceptor {

    Object intercept(Mono<Void> mono);
}
