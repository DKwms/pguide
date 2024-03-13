package com.zyc.download4j.core.source;

import com.zyc.download4j.core.context.DownloadContext;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link SourceFactory} 的适配器。
 */
public interface SourceFactoryAdapter {

    SourceFactory getFactory(Object source, DownloadContext context);
}
