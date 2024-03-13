package com.zyc.download4j.core.handler;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.order.OrderProvider;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载处理器。
 */
public interface DownloadHandler extends OrderProvider {

    int ORDER_LOOKUP_CACHE = 0;
    int ORDER_CREATE_SOURCE = 100;
    int ORDER_LOAD_SOURCE = 200;
    int ORDER_COMPRESS_SOURCE = 300;
    int ORDER_WRITE_RESPONSE = 400;

    Mono<Void> handle(DownloadContext context, DownloadHandlerChain chain);
}
