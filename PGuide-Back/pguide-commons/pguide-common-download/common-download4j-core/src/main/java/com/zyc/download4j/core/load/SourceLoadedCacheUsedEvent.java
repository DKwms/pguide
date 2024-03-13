package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 加载使用缓存时会发布该事件。
 */
@Getter
public class SourceLoadedCacheUsedEvent extends AbstractLoadSourceEvent {

    private final String cache;

    public SourceLoadedCacheUsedEvent(DownloadContext context, Source source, String cache) {
        super(context, source, "Load " + source.getDescription() + " using cache " + cache);
        this.cache = cache;
    }
}
