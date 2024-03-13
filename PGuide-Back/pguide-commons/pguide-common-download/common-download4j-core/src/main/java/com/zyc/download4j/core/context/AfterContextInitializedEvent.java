package com.zyc.download4j.core.context;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 初始化后会发布该事件。
 */
public class AfterContextInitializedEvent extends AbstractInitializeContextEvent {

    public AfterContextInitializedEvent(DownloadContext context) {
        super(context, "Context initialized");
    }
}
