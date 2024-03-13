package com.zyc.download4j.core.web;

import com.zyc.download4j.core.context.DownloadContext;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadResponse} 写入完成后会发布该事件。
 */
public class AfterResponseWrittenEvent extends AbstractWriteResponseEvent {

    public AfterResponseWrittenEvent(DownloadContext context) {
        super(context, "Response written");
    }
}
