package com.zyc.download4j.core.source.http;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.AbstractCreateSourceEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link HttpSource} 创建完成后会发布该事件。
 */
public class HttpSourceCreatedEvent extends AbstractCreateSourceEvent {

    public HttpSourceCreatedEvent(DownloadContext context, HttpSource source) {
        super(context, source);
    }
}
