package com.zyc.download4j.core.concept;

import lombok.Getter;
import lombok.Setter;

import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Resource} 的抽象类。
 */
@Getter
@Setter
public abstract class AbstractResource extends AbstractPart implements Resource {

    protected String name;
    protected String contentType;
    protected Charset charset;
    protected boolean cacheEnabled;
    protected String cachePath;

    @SuppressWarnings("unchecked")
    public static class Builder<T extends AbstractResource, B extends Builder<T, B>> {

        protected String name;
        protected String contentType;
        protected Charset charset;
        protected boolean cacheEnabled;
        protected String cachePath;

        public B name(String name) {
            this.name = name;
            return (B) this;
        }

        public B contentType(String contentType) {
            this.contentType = contentType;
            return (B) this;
        }

        public B charset(Charset charset) {
            this.charset = charset;
            return (B) this;
        }

        public B cacheEnabled(boolean cacheEnabled) {
            this.cacheEnabled = cacheEnabled;
            return (B) this;
        }

        public B cachePath(String cachePath) {
            this.cachePath = cachePath;
            return (B) this;
        }

        protected T build(T target) {
            target.setName(name);
            target.setContentType(contentType);
            target.setCharset(charset);
            target.setCacheEnabled(cacheEnabled);
            target.setCachePath(cachePath);
            return target;
        }
    }
}
