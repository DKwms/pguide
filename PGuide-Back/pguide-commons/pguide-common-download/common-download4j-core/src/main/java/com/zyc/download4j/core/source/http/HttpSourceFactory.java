package com.zyc.download4j.core.source.http;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import com.zyc.download4j.core.source.prefix.PrefixSourceFactory;

import java.net.HttpURLConnection;
import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配前缀 'http://' 或 'https://' 并使用 {@link HttpURLConnection} 的 {@link SourceFactory}。
 */
public class HttpSourceFactory extends PrefixSourceFactory {

    public static final String[] PREFIXES = new String[]{"http://", "https://"};

    @Override
    public Source create(Object source, DownloadContext context) {
        String url = (String) source;
        Charset charset = context.getOptions().getCharset();
        boolean cacheEnabled = context.getOptions().isSourceCacheEnabled();
        String cachePath = context.getOptions().getSourceCachePath();
        HttpSource build = new HttpSource.Builder<>()
                .url(url)
                .asyncLoad(true)
                .charset(charset)
                .cacheEnabled(cacheEnabled)
                .cachePath(cachePath)
                .build();
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new HttpSourceCreatedEvent(context, build));
        return build;
    }

    @Override
    protected String[] getPrefixes() {
        return PREFIXES;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE - 1000;
    }
}
