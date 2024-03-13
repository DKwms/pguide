package com.zyc.download4j.core.write;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadContextEvent;
import com.zyc.download4j.core.utils.DownloadUtils;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 进度相关的事件的父类。
 */
@Getter
public abstract class AbstractProgressEvent extends DownloadContextEvent {

    private final Progress progress;

    public AbstractProgressEvent(@NonNull DownloadContext context, Progress progress, String message) {
        super(context);
        this.progress = progress;
        setMessage(message);
    }

    public String getBaseCurrentMessage() {
        return DownloadUtils.format(progress.getCurrent());
    }

    public String getCurrentMessage() {
        return getBaseCurrentMessage();
    }

    public String getRatioMessage() {
        Progress progress = getProgress();
        if (progress.hasTotal()) {
            return DownloadUtils.format(progress.getCurrent()) + "/" + DownloadUtils.format(progress.getTotal());
        } else {
            return getBaseCurrentMessage();
        }
    }

    public String getPercentageMessage() {
        Progress progress = getProgress();
        if (progress.hasTotal()) {
            double v = (progress.getCurrent() * 1.0 / progress.getTotal()) * 100.0;
            String format = String.format("%.2f", v);
            return format + "%";
        } else {
            return getBaseCurrentMessage();
        }
    }
}
