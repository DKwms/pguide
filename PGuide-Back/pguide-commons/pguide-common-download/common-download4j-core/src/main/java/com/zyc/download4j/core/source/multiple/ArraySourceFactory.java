package com.zyc.download4j.core.source.multiple;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配数组的 {@link SourceFactory}。
 */
public class ArraySourceFactory implements SourceFactory {

    private final SourceFactory factory = new CollectionSourceFactory();

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source != null && source.getClass().isArray();
    }

    @Override
    public Source create(Object source, DownloadContext context) {
        List<Object> objects = new ArrayList<>();
        int length = Array.getLength(source);
        for (int i = 0; i < length; i++) {
            Object o = Array.get(source, i);
            objects.add(o);
        }
        return factory.create(objects, context);
    }
}
