package com.zyc.download4j.core.context;

import com.zyc.download4j.core.options.DownloadOptions;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载上下文。
 *
 * @see DefaultDownloadContext
 */
public interface DownloadContext {

    String getId();

    DownloadOptions getOptions();

    void set(Object key, Object value);

    <T> T get(Object key);

    boolean contains(Object key);

    void remove(Object key);

    void initialize();

    void destroy();
}
