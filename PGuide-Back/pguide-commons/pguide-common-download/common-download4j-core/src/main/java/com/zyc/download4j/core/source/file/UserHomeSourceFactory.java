package com.zyc.download4j.core.source.file;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import com.zyc.download4j.core.source.prefix.PrefixSourceFactory;

import java.io.File;

public class UserHomeSourceFactory extends PrefixSourceFactory {

    public static final String[] PREFIXES = new String[]{
            "user.home:",
            "user_home:",
            "user-home:"};

    public static final String USER_HOME = System.getProperty("user.home");

    private final SourceFactory factory = new FileSourceFactory();

    @Override
    public Source create(Object source, DownloadContext context) {
        String path = getContent((String) source);
        return factory.create(new File(USER_HOME, path), context);
    }

    @Override
    protected String[] getPrefixes() {
        return PREFIXES;
    }
}
