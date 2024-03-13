package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.write.AbstractProgressEvent;
import com.zyc.download4j.core.write.Progress;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 压缩进度更新时会发布该事件。
 */
public class SourceCompressingProgressEvent extends AbstractProgressEvent {

    private static final String CS = "Compressing source ";

    public SourceCompressingProgressEvent(DownloadContext context, Progress progress) {
        super(context, progress, CS + progress.getCurrent() + "/" + progress.getTotal());
    }

    @Override
    public String getCurrentMessage() {
        return CS + super.getCurrentMessage();
    }

    @Override
    public String getRatioMessage() {
        return CS + super.getRatioMessage();
    }

    @Override
    public String getPercentageMessage() {
        return CS + super.getPercentageMessage();
    }
}
