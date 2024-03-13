package com.zyc.download4j.core.web;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadContextEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadResponse} 写入相关的事件的父类。
 */
public class AbstractWriteResponseEvent extends DownloadContextEvent {

    public AbstractWriteResponseEvent(DownloadContext context, String message) {
        super(context);
        setMessage(message);
    }
}
