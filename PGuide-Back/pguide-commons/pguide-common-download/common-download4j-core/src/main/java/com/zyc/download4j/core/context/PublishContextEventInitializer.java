package com.zyc.download4j.core.context;

import com.zyc.download4j.core.event.DownloadEventPublisher;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 初始化后发布 {@link AfterContextInitializedEvent} 事件。
 */
public class PublishContextEventInitializer implements DownloadContextInitializer {

    @Override
    public void initialize(DownloadContext context) {
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new AfterContextInitializedEvent(context));
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE - 1;
    }
}
