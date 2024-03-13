package com.zyc.download4j.core.web;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载请求。
 */
public interface DownloadRequest {

    String getHeader(String name);

    default Range getRange() {
        String range = getHeader("Range");
        return Range.header(range);
    }
}
