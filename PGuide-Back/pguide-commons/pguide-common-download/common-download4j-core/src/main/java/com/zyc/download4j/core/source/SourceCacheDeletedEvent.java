package com.zyc.download4j.core.source;

import com.zyc.download4j.core.context.AbstractDestroyContextEvent;
import com.zyc.download4j.core.context.DownloadContext;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 的缓存删除时会发布该事件。
 */
@Getter
public class SourceCacheDeletedEvent extends AbstractDestroyContextEvent {

    private final Source source;

    public SourceCacheDeletedEvent(DownloadContext context, Source source) {
        super(context, "Source cache deleted");
        this.source = source;
    }
}
