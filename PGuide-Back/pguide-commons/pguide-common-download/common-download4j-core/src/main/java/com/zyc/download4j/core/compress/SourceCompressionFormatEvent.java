package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 当确定 {@link Source} 压缩格式时会发布该事件。
 */
@Getter
public class SourceCompressionFormatEvent extends AbstractCompressSourceEvent {

    private final String format;

    public SourceCompressionFormatEvent(DownloadContext context, Source source, String format) {
        super(context, source, "Compress source using " + format);
        this.format = format;
    }
}
