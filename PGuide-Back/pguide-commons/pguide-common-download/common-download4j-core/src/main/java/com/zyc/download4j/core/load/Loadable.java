package com.zyc.download4j.core.load;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 支持 {@link Source} 的预加载。
 */
public interface Loadable extends Resource {

    Mono<Source> load(DownloadContext context);

    boolean isAsyncLoad();
}
