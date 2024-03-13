package com.zyc.download4j.core.context;

import com.zyc.download4j.core.order.OrderProvider;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 初始化器，{@link DownloadContext} 初始化时会回调。
 */
public interface DownloadContextInitializer extends OrderProvider {

    void initialize(DownloadContext context);
}
