package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 加载器。
 *
 * @see DefaultSourceLoader
 * @see SchedulerSourceLoader
 */
public interface SourceLoader {

    Mono<Source> load(Source source, DownloadContext context);
}
