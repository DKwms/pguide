package com.zyc.download4j.core.source.multiple;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.SourceFactory;
import com.zyc.download4j.core.source.SourceFactoryAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 匹配 {@link Collection} 的 {@link SourceFactory}。
 */
public class CollectionSourceFactory implements SourceFactory {

    @Override
    public boolean support(Object source, DownloadContext context) {
        return source instanceof Collection;
    }

    @Override
    public Source create(Object source, DownloadContext context) {
        SourceFactoryAdapter adapter = context.get(SourceFactoryAdapter.class);
        List<Source> sources = new ArrayList<>();
        for (Object o : ((Collection<?>) source)) {
            SourceFactory factory = adapter.getFactory(o, context);
            Source s = factory.create(o, context);
            sources.add(s);
        }
        return new MultipleSource(sources);
    }
}
