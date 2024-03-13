package com.zyc.download4j.core.source.reactive;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.AbstractCreateSourceEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link WebClientSource} 创建完成后会发布该事件。
 */
public class WebClientSourceCreatedEvent extends AbstractCreateSourceEvent {

    public WebClientSourceCreatedEvent(DownloadContext context, WebClientSource source) {
        super(context, source);
    }
}
