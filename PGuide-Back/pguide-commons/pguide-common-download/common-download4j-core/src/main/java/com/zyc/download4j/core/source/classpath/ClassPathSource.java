package com.zyc.download4j.core.source.classpath;

import com.zyc.download4j.core.source.AbstractSource;
import com.zyc.download4j.core.source.Source;
import lombok.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.InputStream;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 持有 {@link ClassPathResource} 的 {@link Source}
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassPathSource extends AbstractSource {

    @NonNull
    @Setter
    protected ClassPathResource resource;

    @SneakyThrows
    @Override
    public InputStream openInputStream() {
        return resource.getInputStream();
    }

    @Override
    public String getName() {
        String name = super.getName();
        if (!StringUtils.hasText(name)) {
            setName(resource.getFilename());
        }
        return super.getName();
    }

    @SneakyThrows
    @Override
    public Long getLength() {
        long length = resource.contentLength();
        if (length == -1) {
            return null;
        }
        return length;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getDescription() {
        return "ClassPathSource(" + resource.getPath() + ")";
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends ClassPathSource, B extends Builder<T, B>> extends AbstractSource.Builder<T, B> {

        private ClassPathResource resource;

        public B resource(ClassPathResource resource) {
            this.resource = resource;
            return (B) this;
        }

        @Override
        protected T build(T target) {
            target.setResource(resource);
            return super.build(target);
        }

        @Override
        public T build() {
            return build((T) new ClassPathSource());
        }
    }
}
