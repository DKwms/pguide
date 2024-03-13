package com.zyc.download4j.core.web;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.options.DownloadMethod;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadRequestProvider} 抽象类。
 */
public abstract class AbstractDownloadRequestProvider implements DownloadRequestProvider {

    @Override
    public Mono<DownloadRequest> getRequest(DownloadContext context) {
        Object request = context.getOptions().getRequest();
        if (request instanceof DownloadRequest) {
            return Mono.just((DownloadRequest) request);
        }
        DownloadMethod method = context.getOptions().getDownloadMethod();
        Object[] parameters = method == null ? new Object[]{} : method.getParameters();
        return doGetRequest(request, parameters, context);
    }

    public abstract Mono<DownloadRequest> doGetRequest(Object request, Object[] parameters, DownloadContext context);
}
