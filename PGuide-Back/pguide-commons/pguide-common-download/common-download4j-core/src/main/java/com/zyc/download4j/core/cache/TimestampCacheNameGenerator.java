package com.zyc.download4j.core.cache;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 基于时间戳的 {@link CacheNameGenerator}。
 */
public class TimestampCacheNameGenerator extends AbstractCacheNameGenerator {

    @Override
    public String doGenerate(Resource resource, DownloadContext context) {
        return String.valueOf(System.currentTimeMillis());
    }
}
