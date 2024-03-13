package com.zyc.download4j.core.web.reactive;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.web.AbstractDownloadResponseProvider;
import com.zyc.download4j.core.web.DownloadResponse;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link ReactiveDownloadResponse} 的提供者。
 */
public class ReactiveDownloadResponseProvider extends AbstractDownloadResponseProvider {

    @Override
    public Mono<DownloadResponse> doGetResponse(Object response, Object[] parameters, DownloadContext context) {
        return getServerHttpResponse(response, parameters).map(it -> {
            if (it == null) {
                throw new DownloadException("ServerHttpResponse not found");
            } else {
                return new ReactiveDownloadResponse(it);
            }
        });
    }

    protected Mono<ServerHttpResponse> getServerHttpResponse(Object response, Object[] parameters) {
        if (response instanceof ServerHttpResponse) {
            return Mono.just((ServerHttpResponse) response);
        }
        for (Object parameter : parameters) {
            if (parameter instanceof ServerHttpResponse) {
                return Mono.just((ServerHttpResponse) parameter);
            }
        }
        return ReactiveDownloadHolder.getResponse();
    }
}
