package com.zyc.download4j.core.source;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.load.Loadable;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 需要下载的原始数据对象的抽象。
 */
public interface Source extends Resource, Loadable {

    @Override
    default Mono<Source> load(DownloadContext context) {
        return Mono.just(this);
    }

    boolean isSingle();

    default Collection<Source> list() {
        return list(source -> true);
    }

    default Collection<Source> list(Predicate<Source> predicate) {
        if (predicate.test(this)) {
            return Collections.singletonList(this);
        } else {
            return Collections.emptyList();
        }
    }
}
