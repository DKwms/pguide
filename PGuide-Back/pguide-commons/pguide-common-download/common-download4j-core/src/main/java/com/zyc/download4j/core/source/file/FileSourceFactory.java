package com.zyc.download4j.core.source.file;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;

import java.io.File;
import java.nio.charset.Charset;

public class FileSourceFactory implements SourceFactory {

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source instanceof File;
    }

    @Override
    public Source create(Object source, DownloadContext context) {
        Charset charset = context.getOptions().getCharset();
        FileSource build = new FileSource.Builder<>()
                .file((File) source)
                .charset(charset)
                .build();
        DownloadEventPublisher publisher = context.get(DownloadEventPublisher.class);
        publisher.publish(new FileSourceCreatedEvent(context, build));
        return build;
    }
}
