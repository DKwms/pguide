package com.zyc.download4j.core.source.text;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.AbstractCreateSourceEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link TextSource} 创建完成后会发布该事件。
 */
public class TextSourceCreatedEvent extends AbstractCreateSourceEvent {

    public TextSourceCreatedEvent(DownloadContext context, TextSource source) {
        super(context, source);
    }
}
