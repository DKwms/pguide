package com.zyc.download4j.core.event;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadEvent} 发布器。
 *
 * @see SimpleDownloadEventPublisher
 * @see ApplicationDownloadEventPublisher
 */
public interface DownloadEventPublisher {

    void publish(Object event);
}
