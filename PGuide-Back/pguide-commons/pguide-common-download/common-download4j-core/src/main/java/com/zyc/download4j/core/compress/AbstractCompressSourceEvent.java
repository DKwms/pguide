package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadContextEvent;
import com.zyc.download4j.core.source.Source;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 压缩相关的事件的父类。
 */
@Getter
public abstract class AbstractCompressSourceEvent extends DownloadContextEvent {

    @NonNull
    private final Source source;

    public AbstractCompressSourceEvent(DownloadContext context, @NonNull Source source, String message) {
        super(context);
        this.source = source;
        setMessage(message);
    }
}
