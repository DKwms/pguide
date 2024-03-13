package com.zyc.download4j.core.web;

import com.zyc.download4j.core.context.DownloadContext;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadRequest} 的提供者。
 */
public interface DownloadRequestProvider {

    Mono<DownloadRequest> getRequest(DownloadContext context);
}
