package com.zyc.download4j.core.context;

import com.zyc.download4j.core.event.DownloadContextEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 销毁相关的事件的父类。
 */
public class AbstractDestroyContextEvent extends DownloadContextEvent {

    public AbstractDestroyContextEvent(DownloadContext context, String message) {
        super(context);
        setMessage(message);
    }
}
