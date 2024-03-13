package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 当使用 {@link NoCompression} 不压缩时会发布该事件。
 */
public class SourceNoCompressionEvent extends AbstractCompressSourceEvent {

    public SourceNoCompressionEvent(DownloadContext context, Source source) {
        super(context, source, "Compress skipped");
    }
}
