package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 当使用 {@link MemoryCompression} 内存压缩时会发布该事件。
 */
public class SourceMemoryCompressionEvent extends AbstractCompressSourceEvent {

    public SourceMemoryCompressionEvent(DownloadContext context, Source source) {
        super(context, source, "Compress source in memory");
    }
}
