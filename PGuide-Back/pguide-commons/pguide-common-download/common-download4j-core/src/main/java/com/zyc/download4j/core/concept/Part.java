package com.zyc.download4j.core.concept;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 一个 {@link Resource} 可能包含多个部分。
 */
public interface Part {

    InputStream getInputStream();

    String getName();

    default String getPath() {
        return getName();
    }

    String getContentType();

    Charset getCharset();

    Long getLength();

    default Collection<Part> getChildren() {
        return Collections.emptyList();
    }

    default void release() {
    }
}
