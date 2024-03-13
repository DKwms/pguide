package com.zyc.download4j.core.web;

import com.zyc.download4j.core.context.DownloadContext;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadResponse} 的提供者。
 */
public interface DownloadResponseProvider {

    Mono<DownloadResponse> getResponse(DownloadContext context);
}
