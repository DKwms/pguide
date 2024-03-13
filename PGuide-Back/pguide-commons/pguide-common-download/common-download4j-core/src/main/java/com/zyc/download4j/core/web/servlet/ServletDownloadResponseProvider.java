package com.zyc.download4j.core.web.servlet;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.web.AbstractDownloadResponseProvider;
import com.zyc.download4j.core.web.DownloadResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link ServletDownloadResponse} 的提供者。
 */
public class ServletDownloadResponseProvider extends AbstractDownloadResponseProvider {

    @Override
    public Mono<DownloadResponse> doGetResponse(Object response, Object[] parameters, DownloadContext context) {
        HttpServletResponse resp = getHttpServletResponse(response, parameters);
        if (resp == null) {
            throw new DownloadException("HttpServletResponse not found");
        } else {
            return Mono.just(new ServletDownloadResponse(resp));
        }
    }

    protected HttpServletResponse getHttpServletResponse(Object response, Object[] parameters) {
        if (response instanceof HttpServletResponse) {
            return (HttpServletResponse) response;
        } else if (response instanceof ServletServerHttpResponse) {
            return ((ServletServerHttpResponse) response).getServletResponse();
        }
        for (Object parameter : parameters) {
            if (parameter instanceof HttpServletResponse) {
                return (HttpServletResponse) parameter;
            } else if (parameter instanceof ServletServerHttpResponse) {
                return ((ServletServerHttpResponse) parameter).getServletResponse();
            }
        }
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return ((ServletRequestAttributes) attributes).getResponse();
    }
}
