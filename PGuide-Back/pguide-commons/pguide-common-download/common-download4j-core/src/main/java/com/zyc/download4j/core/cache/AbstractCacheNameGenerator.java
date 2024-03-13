package com.zyc.download4j.core.cache;

import com.zyc.download4j.core.compress.Compression;
import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import org.springframework.util.StringUtils;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link CacheNameGenerator} 的抽象类。
 * 将会优先使用 {@link Source} 或 {@link Compression} 的名称。
 */
public abstract class AbstractCacheNameGenerator implements CacheNameGenerator {

    @Override
    public String generate(Resource resource, DownloadContext context) {
        String name = resource.getName();
        if (StringUtils.hasText(name)) {
            return name;
        } else {
            return doGenerate(resource, context);
        }
    }

    public abstract String doGenerate(Resource resource, DownloadContext context);
}
