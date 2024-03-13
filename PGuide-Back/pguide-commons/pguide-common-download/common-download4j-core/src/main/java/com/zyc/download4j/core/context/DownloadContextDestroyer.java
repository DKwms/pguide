package com.zyc.download4j.core.context;

import com.zyc.download4j.core.order.OrderProvider;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 销毁器，{@link DownloadContext} 销毁时会回调。
 */
public interface DownloadContextDestroyer extends OrderProvider {

    void destroy(DownloadContext context);
}
