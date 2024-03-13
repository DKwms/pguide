package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.concept.Part;
import com.zyc.download4j.core.source.Source;
import lombok.AllArgsConstructor;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 不压缩。
 */
@AllArgsConstructor
public class NoCompression implements Compression {

    protected Source source;

    @Override
    public InputStream getInputStream() {
        return source.getInputStream();
    }

    @Override
    public String getName() {
        return source.getName();
    }

    @Override
    public String getContentType() {
        return source.getContentType();
    }

    @Override
    public Charset getCharset() {
        return source.getCharset();
    }

    @Override
    public Long getLength() {
        return source.getLength();
    }

    @Override
    public String getDescription() {
        return "NoCompression:" + source.getDescription();
    }

    @Override
    public Collection<Part> getParts() {
        return source.getParts();
    }

    @Override
    public void release() {
        source.release();
    }
}
