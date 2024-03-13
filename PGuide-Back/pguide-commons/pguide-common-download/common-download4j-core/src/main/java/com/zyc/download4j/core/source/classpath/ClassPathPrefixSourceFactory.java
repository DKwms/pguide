package com.zyc.download4j.core.source.classpath;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import com.zyc.download4j.core.source.prefix.PrefixSourceFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配前缀 'classpath:' 的 {@link SourceFactory}。
 */
public class ClassPathPrefixSourceFactory extends PrefixSourceFactory {

    public static final String[] PREFIXES = new String[]{"classpath:"};

    private final SourceFactory factory = new ClassPathSourceFactory();

    @Override
    public Source create(Object source, DownloadContext context) {
        String path = getContent((String) source);
        return factory.create(new ClassPathResource(path), context);
    }

    @Override
    protected String[] getPrefixes() {
        return PREFIXES;
    }
}
