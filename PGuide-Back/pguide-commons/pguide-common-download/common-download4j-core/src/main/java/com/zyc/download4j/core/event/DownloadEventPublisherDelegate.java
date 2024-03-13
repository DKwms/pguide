package com.zyc.download4j.core.event;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadEventPublisher} 的委派类，用于临时的组合监听器调用。
 */
@AllArgsConstructor
public class DownloadEventPublisherDelegate implements DownloadEventPublisher {

    @NonNull
    private final DownloadEventPublisher delegate;

    @NonNull
    private final DownloadEventListener listener;

    @Override
    public void publish(Object event) {
        delegate.publish(event);
        listener.onEvent(event);
    }
}
