package com.zyc.download4j.core.log;

import com.zyc.download4j.core.compress.AbstractCompressSourceEvent;
import com.zyc.download4j.core.context.AbstractDestroyContextEvent;
import com.zyc.download4j.core.context.AbstractInitializeContextEvent;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadContextEvent;
import com.zyc.download4j.core.load.AbstractLoadSourceEvent;
import com.zyc.download4j.core.source.AbstractCreateSourceEvent;
import com.zyc.download4j.core.web.AbstractWriteResponseEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 标准流程日志。
 * 每个流程相关的事件都会打印。
 */
public class StandardDownloadLogger extends DownloadLogger {

    @Override
    public void logOnEvent(Object event) {
        if (event instanceof DownloadContextEvent) {
            DownloadContextEvent dce = (DownloadContextEvent) event;
            DownloadContext context = dce.getContext();
            if (event instanceof AbstractInitializeContextEvent ||
                    event instanceof AbstractCreateSourceEvent ||
                    event instanceof AbstractLoadSourceEvent ||
                    event instanceof AbstractCompressSourceEvent ||
                    event instanceof AbstractWriteResponseEvent ||
                    event instanceof AbstractDestroyContextEvent) {
                log(context, dce.getMessage());
            }
        }
    }
}
