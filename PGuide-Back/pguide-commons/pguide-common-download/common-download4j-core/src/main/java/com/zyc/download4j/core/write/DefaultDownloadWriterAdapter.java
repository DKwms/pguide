package com.zyc.download4j.core.write;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.web.Range;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadWriterAdapter} 的默认实现。
 */
@Getter
@AllArgsConstructor
public class DefaultDownloadWriterAdapter implements DownloadWriterAdapter {

    private final List<DownloadWriter> writers;

    @Override
    public DownloadWriter getWriter(Resource resource, Range range, DownloadContext context) {
        for (DownloadWriter writer : writers) {
            if (writer.support(resource, range, context)) {
                return writer;
            }
        }
        throw new DownloadException("No DownloadWriter support: " + resource);
    }
}
