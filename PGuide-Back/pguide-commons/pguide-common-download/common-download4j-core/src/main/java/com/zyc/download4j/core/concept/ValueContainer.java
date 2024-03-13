package com.zyc.download4j.core.concept;

import com.zyc.download4j.core.web.reactive.DownloadMono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 值容器，用于方法返回值。
 * 由于 webflux 对返回值类型有校验，
 * 所以需要将返回值包装一层来通过校验。
 *
 * @see DownloadMono
 */
public interface ValueContainer {

    Object getValue();
}
