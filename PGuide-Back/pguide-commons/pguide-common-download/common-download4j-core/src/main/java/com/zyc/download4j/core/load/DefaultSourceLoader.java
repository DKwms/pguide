package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link SourceLoader} 的默认实现。
 */
public class DefaultSourceLoader implements SourceLoader {

    @Override
    public Mono<Source> load(Source source, DownloadContext context) {
        return source.load(context);
    }
}
