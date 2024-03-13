package com.zyc.download4j.core.web.reactive;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.web.AbstractDownloadRequestProvider;
import com.zyc.download4j.core.web.DownloadRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link ReactiveDownloadRequest} 的提供者。
 */
public class ReactiveDownloadRequestProvider extends AbstractDownloadRequestProvider {

    @Override
    public Mono<DownloadRequest> doGetRequest(Object request, Object[] parameters, DownloadContext context) {
        return getServerHttpRequest(request, parameters).map(it -> {
            if (it == null) {
                throw new DownloadException("ServerHttpRequest not found");
            } else {
                return new ReactiveDownloadRequest(it);
            }
        });
    }

    protected Mono<ServerHttpRequest> getServerHttpRequest(Object request, Object[] parameters) {
        if (request instanceof ServerHttpRequest) {
            return Mono.just((ServerHttpRequest) request);
        }
        for (Object parameter : parameters) {
            if (parameter instanceof ServerHttpRequest) {
                return Mono.just((ServerHttpRequest) parameter);
            }
        }
        return ReactiveDownloadHolder.getRequest();
    }
}
