package com.zyc.download4j.core.context;

import com.zyc.download4j.core.options.DownloadOptions;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContextFactory} 的默认实现。
 */
@AllArgsConstructor
public class DefaultDownloadContextFactory implements DownloadContextFactory {

    @NonNull
    private List<DownloadContextInitializer> initializers;

    @NonNull
    private List<DownloadContextDestroyer> destroyers;

    @Override
    public DownloadContext create(DownloadOptions options) {
        DefaultDownloadContext context = new DefaultDownloadContext(UUID.randomUUID().toString(), options);
        context.setInitializers(initializers);
        context.setDestroyers(destroyers);
        return context;
    }
}
