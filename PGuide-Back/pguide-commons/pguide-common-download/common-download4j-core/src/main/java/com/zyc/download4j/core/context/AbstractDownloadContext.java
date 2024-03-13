package com.zyc.download4j.core.context;

import com.zyc.download4j.core.options.DownloadOptions;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 的抽象类。
 */
@Getter
public abstract class AbstractDownloadContext implements DownloadContext {

    private final String id;

    private final DownloadOptions options;

    @NonNull
    @Setter
    private Collection<DownloadContextInitializer> initializers = Collections.emptyList();

    @NonNull
    @Setter
    private Collection<DownloadContextDestroyer> destroyers = Collections.emptyList();

    public AbstractDownloadContext(@NonNull String id, @NonNull DownloadOptions options) {
        this.id = id;
        this.options = options;
    }

    @Override
    public void initialize() {
        initializers.forEach(it -> it.initialize(this));
    }

    @Override
    public void destroy() {
        destroyers.forEach(it -> it.destroy(this));
    }
}
