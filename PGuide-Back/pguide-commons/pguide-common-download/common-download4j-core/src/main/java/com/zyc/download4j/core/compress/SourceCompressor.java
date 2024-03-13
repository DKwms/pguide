package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.compress.zip.ZipSourceCompressor;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.order.OrderProvider;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.write.DownloadWriter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 压缩器。
 *
 * @see ZipSourceCompressor
 */
public interface SourceCompressor extends OrderProvider {

    String getFormat();

    default boolean support(String format, DownloadContext context) {
        return format.equalsIgnoreCase(getFormat());
    }

    Compression compress(Source source, DownloadWriter writer, DownloadContext context);
}
