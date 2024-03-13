package com.zyc.download4j.core.cache;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.context.DownloadContextInitializer;
import lombok.AllArgsConstructor;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 将 {@link CacheNameGenerator} 设置到 {@link DownloadContext} 中。
 */
@AllArgsConstructor
public class CacheNameGeneratorInitializer implements DownloadContextInitializer {

    private CacheNameGenerator cacheNameGenerator;

    @Override
    public void initialize(DownloadContext context) {
        context.set(CacheNameGenerator.class, cacheNameGenerator);
    }
}
