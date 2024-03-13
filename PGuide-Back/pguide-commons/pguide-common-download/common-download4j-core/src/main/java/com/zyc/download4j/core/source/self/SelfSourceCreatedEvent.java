package com.zyc.download4j.core.source.self;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.AbstractCreateSourceEvent;
import com.zyc.download4j.core.source.Source;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 当需要下载的原始数据对象原本就是 {@link Source} 时会发布该事件。
 */
public class SelfSourceCreatedEvent extends AbstractCreateSourceEvent {

    public SelfSourceCreatedEvent(DownloadContext context, Source source) {
        super(context, source);
    }
}
