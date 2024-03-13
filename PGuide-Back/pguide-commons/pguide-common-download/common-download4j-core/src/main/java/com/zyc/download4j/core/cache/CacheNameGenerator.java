package com.zyc.download4j.core.cache;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 缓存名称生成器。
 *
 * @see TimestampCacheNameGenerator
 */
public interface CacheNameGenerator {

    String generate(Resource resource, DownloadContext context);
}
