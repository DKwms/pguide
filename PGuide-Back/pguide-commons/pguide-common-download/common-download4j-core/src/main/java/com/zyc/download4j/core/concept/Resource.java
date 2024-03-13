package com.zyc.download4j.core.concept;

import com.zyc.download4j.core.cache.Cacheable;
import com.zyc.download4j.core.compress.Compression;
import com.zyc.download4j.core.source.Source;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载资源，抽象 {@link Source} 和 {@link Compression} 的通用部分。
 */
public interface Resource extends Part, Cacheable {

    String getDescription();

    default Collection<Part> getParts() {
        Collection<Part> parts = new ArrayList<>();
        addPart(this, parts);
        return parts;
    }

    static void addPart(Part part, Collection<Part> parts) {
        parts.add(part);
        for (Part child : part.getChildren()) {
            addPart(child, parts);
        }
    }
}
