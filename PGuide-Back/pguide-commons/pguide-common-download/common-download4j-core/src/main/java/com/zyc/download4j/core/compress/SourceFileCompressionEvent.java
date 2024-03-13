package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import lombok.Getter;

import java.io.File;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 当使用 {@link FileCompression} 文件压缩时会发布该事件。
 */
@Getter
public class SourceFileCompressionEvent extends AbstractCompressSourceEvent {

    private final File file;

    public SourceFileCompressionEvent(DownloadContext context, Source source, File file) {
        super(context, source, "Compress source with file " + file.getAbsolutePath());
        this.file = file;
    }
}
