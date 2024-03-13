package com.zyc.download4j.core.web.servlet;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.web.AbstractDownloadRequestProvider;
import com.zyc.download4j.core.web.DownloadRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link ServletDownloadRequest} 的提供者。
 */
public class ServletDownloadRequestProvider extends AbstractDownloadRequestProvider {

    @Override
    public Mono<DownloadRequest> doGetRequest(Object request, Object[] parameters, DownloadContext context) {
        HttpServletRequest req = getHttpServletRequest(request, parameters);
        if (req == null) {
            throw new DownloadException("HttpServletRequest not found");
        } else {
            return Mono.just(new ServletDownloadRequest(req));
        }
    }

    protected HttpServletRequest getHttpServletRequest(Object request, Object[] parameters) {
        if (request instanceof HttpServletRequest) {
            return (HttpServletRequest) request;
        } else if (request instanceof ServletServerHttpRequest) {
            return ((ServletServerHttpRequest) request).getServletRequest();
        }
        for (Object parameter : parameters) {
            if (parameter instanceof HttpServletRequest) {
                return (HttpServletRequest) parameter;
            } else if (parameter instanceof ServletServerHttpRequest) {
                return ((ServletServerHttpRequest) parameter).getServletRequest();
            }
        }
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return ((ServletRequestAttributes) attributes).getRequest();
    }
}
