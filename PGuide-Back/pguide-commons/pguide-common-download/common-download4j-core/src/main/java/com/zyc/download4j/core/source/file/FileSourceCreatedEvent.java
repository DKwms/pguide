package com.zyc.download4j.core.source.file;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.AbstractCreateSourceEvent;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link FileSource} 创建完成后会发布该事件。
 */
public class FileSourceCreatedEvent extends AbstractCreateSourceEvent {

    public FileSourceCreatedEvent(DownloadContext context, FileSource source) {
        super(context, source);
    }
}
