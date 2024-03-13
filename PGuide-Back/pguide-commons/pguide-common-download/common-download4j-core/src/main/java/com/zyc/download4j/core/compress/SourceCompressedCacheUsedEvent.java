package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 压缩使用缓存时会发布该事件。
 */
@Getter
public class SourceCompressedCacheUsedEvent extends AbstractCompressSourceEvent {

    private final String cache;

    public SourceCompressedCacheUsedEvent(DownloadContext context, Source source, String cache) {
        super(context, source, "Compress source using cache " + cache);
        this.cache = cache;
    }
}
