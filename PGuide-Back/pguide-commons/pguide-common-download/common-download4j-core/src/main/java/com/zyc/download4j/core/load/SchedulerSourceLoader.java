package com.zyc.download4j.core.load;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.multiple.MultipleSource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Collection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 支持 {@link Scheduler} 的 {@link SourceLoader}。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerSourceLoader extends ConcurrentSourceLoader {

    private Scheduler scheduler = Schedulers.immediate();

    @Override
    public Mono<Source> concurrentLoad(Collection<Source> sources, DownloadContext context) {
        MultipleSource source = Flux.fromIterable(sources)
                .parallel()
                .runOn(scheduler)
                .flatMap(it -> it.load(context))
                .collectSortedList((o1, o2) -> 0)
                .map(MultipleSource::new)
                .block();
        return Mono.justOrEmpty(source);
    }
}
