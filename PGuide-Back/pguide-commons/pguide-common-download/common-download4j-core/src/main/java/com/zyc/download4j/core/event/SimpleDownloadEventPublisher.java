package com.zyc.download4j.core.event;

import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadEventPublisher} 的简单实现，支持 {@link DownloadEventListener} 的监听机制。
 */
@AllArgsConstructor
public class SimpleDownloadEventPublisher implements DownloadEventPublisher {

    private Collection<DownloadEventListener> listeners;

    @Override
    public void publish(Object event) {
        if (listeners != null) {
            listeners.forEach(it -> it.onEvent(event));
        }
    }
}
