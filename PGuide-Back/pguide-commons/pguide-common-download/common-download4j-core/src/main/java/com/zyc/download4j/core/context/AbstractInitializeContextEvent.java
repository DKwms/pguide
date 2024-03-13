package com.zyc.download4j.core.context;

import com.zyc.download4j.core.event.DownloadContextEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 初始化相关的事件的父类。
 */
public class AbstractInitializeContextEvent extends DownloadContextEvent {

    public AbstractInitializeContextEvent(DownloadContext context, String message) {
        super(context);
        setMessage(message);
    }
}
