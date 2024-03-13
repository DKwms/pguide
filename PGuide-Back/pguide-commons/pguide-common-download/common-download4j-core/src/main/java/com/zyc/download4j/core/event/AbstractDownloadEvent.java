package com.zyc.download4j.core.event;

import lombok.Getter;
import lombok.Setter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadEvent} 的抽象类。
 */
@Getter
@Setter
public abstract class AbstractDownloadEvent implements DownloadEvent {

    private String message;
}
