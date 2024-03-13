package com.zyc.download4j.core.web;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.write.AbstractProgressEvent;
import com.zyc.download4j.core.write.Progress;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadResponse} 写入进度更新时会发布该事件。
 */
public class ResponseWritingProgressEvent extends AbstractProgressEvent {

    private static final String WR = "Writing response ";

    public ResponseWritingProgressEvent(DownloadContext context, Progress progress) {
        super(context, progress, WR + progress.getCurrent() + "/" + progress.getTotal());
    }

    @Override
    public String getCurrentMessage() {
        return WR + super.getCurrentMessage();
    }

    @Override
    public String getRatioMessage() {
        return WR + super.getRatioMessage();
    }

    @Override
    public String getPercentageMessage() {
        return WR + super.getPercentageMessage();
    }
}
