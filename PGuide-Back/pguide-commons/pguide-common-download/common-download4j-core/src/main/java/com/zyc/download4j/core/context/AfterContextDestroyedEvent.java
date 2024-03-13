package com.zyc.download4j.core.context;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 销毁后会发布该事件。
 */
public class AfterContextDestroyedEvent extends AbstractDestroyContextEvent {

    public AfterContextDestroyedEvent(DownloadContext context) {
        super(context, "Context destroyed");
    }
}
