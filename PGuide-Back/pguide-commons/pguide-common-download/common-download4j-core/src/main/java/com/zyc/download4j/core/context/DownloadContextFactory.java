package com.zyc.download4j.core.context;

import com.zyc.download4j.core.options.DownloadOptions;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 工厂。
 */
public interface DownloadContextFactory {

    DownloadContext create(DownloadOptions options);
}
