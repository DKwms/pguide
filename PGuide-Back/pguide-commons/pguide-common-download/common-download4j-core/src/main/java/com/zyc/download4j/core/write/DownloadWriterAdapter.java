package com.zyc.download4j.core.write;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.web.Range;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadWriter} 的适配器。
 */
public interface DownloadWriterAdapter {

    DownloadWriter getWriter(Resource resource, Range range, DownloadContext context);
}
