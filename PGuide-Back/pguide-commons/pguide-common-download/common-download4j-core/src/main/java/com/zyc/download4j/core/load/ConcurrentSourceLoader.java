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

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 支持并发的 {@link SourceLoader}。
 */
@NoArgsConstructor
@AllArgsConstructor
public abstract class ConcurrentSourceLoader implements SourceLoader {

    @Getter
    @Setter
    private boolean serialOnSingle = true;

    @Override
    public Mono<Source> load(Source source, DownloadContext context) {
        Collection<Source> syncSources = new ArrayList<>();
        Collection<Source> asyncSources = new ArrayList<>();
        Collection<Source> sources = source.list();
        for (Source s : sources) {
            if (s.isAsyncLoad()) {
                asyncSources.add(s);
            } else {
                syncSources.add(s);
            }
        }

        if (asyncSources.isEmpty()) {
            return Flux.fromIterable(syncSources)
                    .flatMap(it -> it.load(context))
                    .collectList()
                    .map(MultipleSource::new);
        } else {
            if (asyncSources.size() == 1 && serialOnSingle) {
                syncSources.add(asyncSources.iterator().next());
                return Flux.fromIterable(syncSources)
                        .flatMap(it -> it.load(context))
                        .collectList()
                        .map(MultipleSource::new);
            } else {
                Mono<Source> syncMono =  Flux.fromIterable(syncSources)
                        .flatMap(it -> it.load(context))
                        .collectList()
                        .map(MultipleSource::new);
                Mono<Source> asyncMono = concurrentLoad(asyncSources, context);
                return Mono.zip(syncMono, asyncMono).map(objects -> {
                    Collection<Source> newSources = new ArrayList<>();
                    newSources.addAll(objects.getT1().list());
                    newSources.addAll(objects.getT2().list());
                    return new MultipleSource(newSources);
                });
            }
        }
    }

    public abstract Mono<Source> concurrentLoad(Collection<Source> sources, DownloadContext context);
}
