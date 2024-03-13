package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadContextEvent;
import com.zyc.download4j.core.source.Source;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 加载相关的事件的父类。
 */
@Getter
public abstract class AbstractLoadSourceEvent extends DownloadContextEvent {

    @NonNull
    private final Source source;

    public AbstractLoadSourceEvent(DownloadContext context, @NonNull Source source, String message) {
        super(context);
        this.source = source;
        setMessage(message);
    }
}
