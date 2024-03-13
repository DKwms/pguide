package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.utils.DownloadUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 内存压缩。
 */
@AllArgsConstructor
public class MemoryCompression extends AbstractCompression {

    @NonNull
    protected final byte[] bytes;

    @Override
    public InputStream openInputStream() {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public Long getLength() {
        return (long) bytes.length;
    }

    @Override
    public String getDescription() {
        return "MemoryCompression(" + DownloadUtils.format(getLength()) + ")";
    }
}
