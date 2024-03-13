package com.zyc.download4j.core.source;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.exception.DownloadException;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link SourceFactoryAdapter} 的默认实现。
 */
@AllArgsConstructor
public class DefaultSourceFactoryAdapter implements SourceFactoryAdapter {

    private final List<SourceFactory> factories;

    @Override
    public SourceFactory getFactory(Object source, DownloadContext context) {
        for (SourceFactory factory : factories) {
            if (factory.support(source, context)) {
                return factory;
            }
        }
        throw new DownloadException("No SourceFactory support: " + source);
    }
}
