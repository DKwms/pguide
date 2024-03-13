package com.zyc.download4j.core.event;

import com.zyc.download4j.core.context.DownloadContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 附带了 {@link DownloadContext} 的 {@link DownloadEvent}。
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class DownloadContextEvent extends AbstractDownloadEvent {

    @NonNull
    private final DownloadContext context;
}
