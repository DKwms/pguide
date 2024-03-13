package com.zyc.download4j.core.web.reactive;

import com.zyc.download4j.core.web.DownloadRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 持有 {@link ServerHttpRequest} 的 {@link DownloadRequest}，用于 webflux。
 */
@Getter
@AllArgsConstructor
public class ReactiveDownloadRequest implements DownloadRequest {

    private ServerHttpRequest request;

    @Override
    public String getHeader(String name) {
        return request.getHeaders().getFirst(name);
    }
}
