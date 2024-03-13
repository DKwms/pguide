package com.zyc.download4j.core.event;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.context.DownloadContextInitializer;
import lombok.AllArgsConstructor;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadEventPublisher} 初始化器。
 * 在 {@link DownloadContext} 初始化时，设置 {@link DownloadEventPublisher}。
 */
@AllArgsConstructor
public class DownloadEventPublisherInitializer implements DownloadContextInitializer {

    private DownloadEventPublisher eventPublisher;

    @Override
    public void initialize(DownloadContext context) {
        DownloadEventListener listener = context.getOptions().getEventListener();
        DownloadEventPublisher publisher;
        if (listener == null) {
            publisher = eventPublisher;
        } else {
            publisher = new DownloadEventPublisherDelegate(eventPublisher, listener);
        }
        context.set(DownloadEventPublisher.class, publisher);
    }
}
