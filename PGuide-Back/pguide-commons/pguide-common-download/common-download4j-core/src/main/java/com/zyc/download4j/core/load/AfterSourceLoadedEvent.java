package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 加载完成后会发布该事件。
 */
@Getter
public class AfterSourceLoadedEvent extends AbstractLoadSourceEvent {

    public AfterSourceLoadedEvent(DownloadContext context, Source source) {
        super(context, source, "Source loaded");
    }
}
