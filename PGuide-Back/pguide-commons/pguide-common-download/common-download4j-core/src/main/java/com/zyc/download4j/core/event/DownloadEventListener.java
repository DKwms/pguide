package com.zyc.download4j.core.event;

import com.zyc.download4j.core.order.OrderProvider;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadEvent} 的监听器。
 */
public interface DownloadEventListener extends OrderProvider {

    void onEvent(Object event);
}
