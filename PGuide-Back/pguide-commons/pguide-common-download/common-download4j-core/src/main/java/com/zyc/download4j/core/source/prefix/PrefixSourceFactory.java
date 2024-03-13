package com.zyc.download4j.core.source.prefix;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.SourceFactory;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 基于字符串前缀匹配的 {@link SourceFactory}。
 */
public abstract class PrefixSourceFactory implements SourceFactory {

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source instanceof String && (matchPrefix((String) source) != null);
    }

    protected String matchPrefix(String source) {
        String[] prefixes = getPrefixes();
        for (String prefix : prefixes) {
            if (source.startsWith(prefix)) {
                return prefix;
            }
        }
        return null;
    }

    protected String getContent(String source) {
        String prefix = matchPrefix(source);
        return source.substring(prefix.length());
    }

    protected abstract String[] getPrefixes();
}
