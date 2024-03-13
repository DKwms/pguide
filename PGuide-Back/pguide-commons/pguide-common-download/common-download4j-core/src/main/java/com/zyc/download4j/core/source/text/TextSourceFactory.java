package com.zyc.download4j.core.source.text;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;

import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配任意文本的 {@link Source}。
 */
public class TextSourceFactory implements SourceFactory {

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source instanceof String;
    }

    @Override
    public Source create(Object source, DownloadContext context) {
        Charset charset = context.getOptions().getCharset();
        TextSource build = new TextSource.Builder<>()
                .text((String) source)
                .name("text.txt")
                .charset(charset)
                .build();
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new TextSourceCreatedEvent(context, build));
        return build;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE - 100;
    }
}
