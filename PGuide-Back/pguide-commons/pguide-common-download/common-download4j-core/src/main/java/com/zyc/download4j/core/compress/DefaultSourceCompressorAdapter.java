package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.exception.DownloadException;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link SourceCompressorAdapter} 的默认实现。
 */
@AllArgsConstructor
public class DefaultSourceCompressorAdapter implements SourceCompressorAdapter {

    private final List<SourceCompressor> compressors;

    @Override
    public SourceCompressor getCompressor(String format, DownloadContext context) {
        for (SourceCompressor compressor : compressors) {
            if (compressor.support(format, context)) {
                return compressor;
            }
        }
        throw new DownloadException("No SourceCompressor support: " + format);
    }
}
