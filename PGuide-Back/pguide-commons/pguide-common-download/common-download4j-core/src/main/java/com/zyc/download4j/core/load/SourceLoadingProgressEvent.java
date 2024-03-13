package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.write.AbstractProgressEvent;
import com.zyc.download4j.core.write.Progress;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 加载进度更新时会发布该事件。
 */
@Getter
public class SourceLoadingProgressEvent extends AbstractProgressEvent {

    private static final String L = "Loading ";

    private final Source source;

    public SourceLoadingProgressEvent(DownloadContext context, Source source, Progress progress) {
        super(context, progress, getLS(source) + progress.getCurrent() + "/" + progress.getTotal());
        this.source = source;
    }

    @Override
    public String getCurrentMessage() {
        return getLS() + super.getCurrentMessage();
    }

    @Override
    public String getRatioMessage() {
        return getLS() + super.getRatioMessage();
    }

    @Override
    public String getPercentageMessage() {
        return getLS() + super.getPercentageMessage();
    }

    public String getLS() {
        return getLS(source);
    }

    public static String getLS(Source source) {
        return L + source.getDescription() + " ";
    }
}
