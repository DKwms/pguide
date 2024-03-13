package com.zyc.download4j.core.source;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.order.OrderProvider;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 工厂。
 */
public interface SourceFactory extends OrderProvider {

    boolean support(Object source, DownloadContext context);

    Source create(Object source, DownloadContext context);
}
