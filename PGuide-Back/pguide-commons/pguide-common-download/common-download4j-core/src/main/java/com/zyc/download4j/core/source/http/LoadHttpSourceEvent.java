package com.zyc.download4j.core.source.http;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.load.AbstractLoadSourceEvent;

import java.net.HttpURLConnection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 使用 {@link HttpURLConnection} 加载时会发布该事件。
 */
public class LoadHttpSourceEvent extends AbstractLoadSourceEvent {

    public LoadHttpSourceEvent(DownloadContext context, HttpSource source) {
        super(context, source, "Load " + source.getDescription() + " using Http(s)URLConnection");
    }
}
