package com.zyc.download4j.core.source.classpath;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.AbstractCreateSourceEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link ClassPathSource} 创建完成后会发布该事件。
 */
public class ClassPathSourceCreatedEvent extends AbstractCreateSourceEvent {

    public ClassPathSourceCreatedEvent(DownloadContext context, ClassPathSource source) {
        super(context, source);
    }
}
