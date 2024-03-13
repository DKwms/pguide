package com.zyc.download4j.core.source;

import com.zyc.download4j.core.concept.AbstractResource;
import lombok.Getter;
import lombok.Setter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 的抽象类。
 */
@Getter
@Setter
public abstract class AbstractSource extends AbstractResource implements Source {

    protected boolean asyncLoad;

    @SuppressWarnings("unchecked")
    public static abstract class Builder<T extends AbstractSource, B extends Builder<T, B>> extends AbstractResource.Builder<T, B> {

        protected boolean asyncLoad;

        public B asyncLoad(boolean asyncLoad) {
            this.asyncLoad = asyncLoad;
            return (B) this;
        }

        @Override
        protected T build(T target) {
            target.setAsyncLoad(asyncLoad);
            return super.build(target);
        }

        public abstract T build();
    }
}
