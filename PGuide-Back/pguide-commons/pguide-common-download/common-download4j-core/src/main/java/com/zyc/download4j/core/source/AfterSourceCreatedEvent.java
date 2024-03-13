package com.zyc.download4j.core.source;

import com.zyc.download4j.core.context.DownloadContext;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 创建完成后会发布该事件。
 */
@Getter
public class AfterSourceCreatedEvent extends AbstractCreateSourceEvent {

    public AfterSourceCreatedEvent(DownloadContext context, Source source) {
        super(context, source, "Source created");
    }
}
