package com.zyc.download4j.core.source.reactive;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import com.zyc.download4j.core.source.http.HttpSourceFactory;
import com.zyc.download4j.core.source.prefix.PrefixSourceFactory;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配前缀 'http://' 或 'https://' 并使用 {@link WebClient} 的 {@link SourceFactory}。
 */
public class WebClientSourceFactory extends PrefixSourceFactory {

    @Override
    public Source create(Object source, DownloadContext context) {
        String url = (String) source;
        Charset charset = context.getOptions().getCharset();
        boolean cacheEnabled = context.getOptions().isSourceCacheEnabled();
        String cachePath = context.getOptions().getSourceCachePath();
        WebClientSource build = new WebClientSource.Builder<>()
                .url(url)
                .asyncLoad(true)
                .charset(charset)
                .cacheEnabled(cacheEnabled)
                .cachePath(cachePath)
                .build();
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new WebClientSourceCreatedEvent(context, build));
        return build;
    }

    @Override
    protected String[] getPrefixes() {
        return HttpSourceFactory.PREFIXES;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE + 1000;
    }
}
