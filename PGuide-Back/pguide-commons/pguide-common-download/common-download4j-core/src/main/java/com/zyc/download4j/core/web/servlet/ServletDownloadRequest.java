package com.zyc.download4j.core.web.servlet;

import com.zyc.download4j.core.web.DownloadRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 持有 {@link HttpServletRequest} 的 {@link DownloadRequest}，用于 webmvc。
 */
@Getter
@AllArgsConstructor
public class ServletDownloadRequest implements DownloadRequest {

    private HttpServletRequest request;

    @Override
    public String getHeader(String name) {
        return request.getHeader(name);
    }
}
