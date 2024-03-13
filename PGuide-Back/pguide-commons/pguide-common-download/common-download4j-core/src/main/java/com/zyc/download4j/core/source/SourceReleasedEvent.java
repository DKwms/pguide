package com.zyc.download4j.core.source;

import com.zyc.download4j.core.context.AbstractDestroyContextEvent;
import com.zyc.download4j.core.context.DownloadContext;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 的资源释放时会发布该事件。
 */
@Getter
public class SourceReleasedEvent extends AbstractDestroyContextEvent {

    private final Source source;

    public SourceReleasedEvent(DownloadContext context, Source source) {
        super(context, "Source resource released");
        this.source = source;
    }
}
