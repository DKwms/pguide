package com.zyc.download4j.core.source.multiple;

import com.zyc.download4j.core.cache.Cacheable;
import com.zyc.download4j.core.concept.Part;
import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.source.file.EmptyInputStream;
import lombok.*;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 容器化的 {@link Source} 实现。
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MultipleSource implements Source {

    @NonNull
    protected Collection<Source> sources;

    @Override
    public InputStream getInputStream() {
        return new EmptyInputStream();
    }

    @Override
    public String getName() {
        for (Source source : sources) {
            String name = source.getName();
            if (StringUtils.hasText(name)) {
                return name;
            }
        }
        return null;
    }

    @Override
    public String getContentType() {
        Set<String> contentTypes = new HashSet<>();
        for (Source source : sources) {
            contentTypes.add(source.getContentType());
        }
        if (contentTypes.size() == 1) {
            return contentTypes.iterator().next();
        } else {
            return null;
        }
    }

    @Override
    public Charset getCharset() {
        Set<Charset> charsets = new HashSet<>();
        for (Source source : sources) {
            charsets.add(source.getCharset());
        }
        if (charsets.size() == 1) {
            return charsets.iterator().next();
        } else {
            return null;
        }
    }

    @Override
    public Long getLength() {
        long length = 0;
        for (Source source : sources) {
            Long l = source.getLength();
            if (l == null || l < 0) {
                return null;
            }
            length += l;
        }
        return length;
    }

    @Override
    public boolean isAsyncLoad() {
        for (Source source : sources) {
            if (source.isAsyncLoad()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSingle() {
        Boolean single = null;
        for (Source source : sources) {
            if (single == null) {
                single = source.isSingle();
                if (!single) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getDescription() {
        List<String> descriptions = new ArrayList<>();
        Collection<Source> list = list();
        for (Source s : list) {
            descriptions.add(s.getDescription());
        }
        return descriptions.toString();
    }

    @Override
    public Mono<Source> load(DownloadContext context) {
        return Flux.fromIterable(sources)
                .flatMap(it -> it.load(context))
                .collectList()
                .map(MultipleSource::new);
    }

    @Override
    public Collection<Part> getParts() {
        Collection<Part> parts = new ArrayList<>();
        for (Source source : sources) {
            parts.addAll(source.getParts());
        }
        return parts;
    }

    @Override
    public Collection<Source> list(Predicate<Source> predicate) {
        List<Source> all = new ArrayList<>();
        for (Source source : sources) {
            all.addAll(source.list(predicate));
        }
        return all;
    }

    @Override
    public void deleteCache() {
        sources.forEach(Cacheable::deleteCache);
    }

    @Override
    public void release() {
        sources.forEach(Resource::release);
    }
}
