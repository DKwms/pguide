package com.zyc.download4j.core.source.reactive;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.load.AbstractLoadSourceEvent;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 使用 {@link WebClient} 加载时会发布该事件。
 */
public class LoadWebClientSourceEvent extends AbstractLoadSourceEvent {

    public LoadWebClientSourceEvent(DownloadContext context, WebClientSource source) {
        super(context, source, "Load " + source.getDescription() + " using WebClient(webflux)");
    }
}
