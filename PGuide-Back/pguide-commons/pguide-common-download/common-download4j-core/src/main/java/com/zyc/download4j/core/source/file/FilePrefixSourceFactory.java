package com.zyc.download4j.core.source.file;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import com.zyc.download4j.core.source.prefix.PrefixSourceFactory;

import java.io.File;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配前缀 'file:' 的 {@link SourceFactory}。
 */
public class FilePrefixSourceFactory extends PrefixSourceFactory {

    public static final String[] PREFIXES = new String[]{"file:"};

    private final SourceFactory factory = new FileSourceFactory();

    @Override
    public Source create(Object source, DownloadContext context) {
        String path = getContent((String) source);
        return factory.create(new File(path), context);
    }

    @Override
    protected String[] getPrefixes() {
        return PREFIXES;
    }
}
