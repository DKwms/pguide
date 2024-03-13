package com.zyc.download4j.core.write;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.order.OrderProvider;
import com.zyc.download4j.core.web.Range;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 具体操作 {@link InputStream} 和 {@link OutputStream} 的写入器。
 */
public interface DownloadWriter extends OrderProvider {

    boolean support(Resource resource, Range range, DownloadContext context);

    default void write(InputStream is, OutputStream os, Range range, Charset charset, Long length) {
        write(is, os, range, charset, length, null);
    }

    void write(InputStream is, OutputStream os, Range range, Charset charset, Long length, Callback callback);

    interface Callback {

        void onWrite(long current, long increase);
    }
}
