package com.zyc.download4j.core.cache;

import com.zyc.download4j.core.compress.Compression;
import com.zyc.download4j.core.source.Source;

import java.io.File;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 支持 {@link Source} 和 {@link Compression} 的缓存处理。
 */
public interface Cacheable {

    String PATH = new File(System.getProperty("user.home"), "commons/download").getAbsolutePath();

    default boolean isCacheEnabled() {
        return false;
    }

    default boolean isCacheExisted() {
        return false;
    }

    default String getCachePath() {
        return null;
    }

    default void deleteCache() {
    }
}
