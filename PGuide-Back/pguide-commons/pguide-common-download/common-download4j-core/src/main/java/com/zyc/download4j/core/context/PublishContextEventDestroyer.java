package com.zyc.download4j.core.context;

import com.zyc.download4j.core.event.DownloadEventPublisher;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 销毁时发布 {@link AfterContextDestroyedEvent} 事件。
 */
public class PublishContextEventDestroyer implements DownloadContextDestroyer {

    @Override
    public void destroy(DownloadContext context) {
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new AfterContextDestroyedEvent(context));
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE - 1;
    }
}
