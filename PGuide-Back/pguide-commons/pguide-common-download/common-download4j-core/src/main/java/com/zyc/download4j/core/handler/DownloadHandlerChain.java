package com.zyc.download4j.core.handler;

import com.zyc.download4j.core.context.DownloadContext;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载处理链。
 */
public interface DownloadHandlerChain {

    Mono<Void> next(DownloadContext context);
}
