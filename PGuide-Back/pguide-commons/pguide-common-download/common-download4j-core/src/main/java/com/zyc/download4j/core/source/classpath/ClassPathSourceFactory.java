package com.zyc.download4j.core.source.classpath;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配 {@link ClassPathResource} 对象的 {@link SourceFactory}。
 */
public class ClassPathSourceFactory implements SourceFactory {

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source instanceof ClassPathResource;
    }

    @Override
    public Source create(Object source, DownloadContext context) {
        Charset charset = context.getOptions().getCharset();
        ClassPathSource build = new ClassPathSource.Builder<>()
                .resource((ClassPathResource) source)
                .charset(charset)
                .build();
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new ClassPathSourceCreatedEvent(context, build));
        return build;
    }
}
