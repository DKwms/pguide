package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 当加载已经加载过的 {@link Source} 会发布该事件。
 */
public class SourceAlreadyLoadedEvent extends AbstractLoadSourceEvent {

    public SourceAlreadyLoadedEvent(DownloadContext context, Source source) {
        super(context, source, "Skip load " + source.getDescription() + " because it has already been loaded");
    }
}
