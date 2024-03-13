package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link SourceCompressor} 适配器。
 */
public interface SourceCompressorAdapter {

    SourceCompressor getCompressor(String format, DownloadContext context);
}
