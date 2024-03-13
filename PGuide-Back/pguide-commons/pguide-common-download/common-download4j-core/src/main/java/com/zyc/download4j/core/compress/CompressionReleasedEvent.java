package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.AbstractDestroyContextEvent;
import com.zyc.download4j.core.context.DownloadContext;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Compression} 的资源释放时会发布该事件。
 */
@Getter
public class CompressionReleasedEvent extends AbstractDestroyContextEvent {

    private final Compression compression;

    public CompressionReleasedEvent(DownloadContext context, Compression compression) {
        super(context, "Compression resource released");
        this.compression = compression;
    }
}
