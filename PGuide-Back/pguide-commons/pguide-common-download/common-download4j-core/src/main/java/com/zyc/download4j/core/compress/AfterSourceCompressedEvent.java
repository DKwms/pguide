package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.utils.DownloadUtils;
import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Source} 压缩完成后会发布该事件。
 */
@Getter
public class AfterSourceCompressedEvent extends AbstractCompressSourceEvent {

    private final Compression compression;

    public AfterSourceCompressedEvent(DownloadContext context, Source source, Compression compression) {
        super(context, source, null);
        this.compression = compression;
        setMessage("Source compressed " + formatCompressedSize(source, compression));
    }

    public String formatCompressedSize(Source source, Compression compression) {
        Long sl = source.getLength();
        Long cl = compression.getLength();
        StringBuilder builder = new StringBuilder();
        if (sl == null) {
            builder.append("?");
        } else {
            builder.append(DownloadUtils.format(source.getLength()));
        }
        builder.append(" => ");
        if (cl == null) {
            builder.append("?");
        } else {
            builder.append(DownloadUtils.format(compression.getLength()));
        }

        if (sl != null && cl != null) {
            double r = cl.doubleValue() / sl.doubleValue() * 100.0;
            builder.append(" (").append(String.format("%.2f", r)).append("%)");
        }
        return builder.toString();
    }
}
