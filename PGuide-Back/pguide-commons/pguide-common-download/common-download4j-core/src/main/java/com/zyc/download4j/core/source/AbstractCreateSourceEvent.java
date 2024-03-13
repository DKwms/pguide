package com.zyc.download4j.core.source;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadContextEvent;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 创建相关的事件的父类。
 */
@Getter
public abstract class AbstractCreateSourceEvent extends DownloadContextEvent {

    @NonNull
    private final Source source;

    public AbstractCreateSourceEvent(DownloadContext context, @NonNull Source source) {
        this(context, source, "Create " + source.getDescription());
    }

    public AbstractCreateSourceEvent(DownloadContext context, @NonNull Source source, String message) {
        super(context);
        this.source = source;
        setMessage(message);
    }
}
