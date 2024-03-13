package com.zyc.download4j.core.web;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.options.DownloadMethod;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadResponseProvider} 抽象类。
 */
public abstract class AbstractDownloadResponseProvider implements DownloadResponseProvider {

    @Override
    public Mono<DownloadResponse> getResponse(DownloadContext context) {
        Object response = context.getOptions().getResponse();
        if (response instanceof DownloadResponse) {
            return Mono.just((DownloadResponse) response);
        }
        DownloadMethod method = context.getOptions().getDownloadMethod();
        Object[] parameters = method == null ? new Object[]{} : method.getParameters();
        return doGetResponse(response, parameters, context);
    }

    public abstract Mono<DownloadResponse> doGetResponse(Object response, Object[] parameters, DownloadContext context);
}
