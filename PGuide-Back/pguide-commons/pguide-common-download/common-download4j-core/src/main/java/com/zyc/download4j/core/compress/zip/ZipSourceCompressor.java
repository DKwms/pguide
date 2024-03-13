package com.zyc.download4j.core.compress.zip;

import com.zyc.download4j.core.compress.AbstractSourceCompressor;
import com.zyc.download4j.core.compress.CompressFormat;
import com.zyc.download4j.core.concept.Part;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.web.ContentType;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 使用 {@link ZipOutputStream} 进行压缩。
 */
@AllArgsConstructor
public class ZipSourceCompressor extends AbstractSourceCompressor<ZipOutputStream> {

    @Override
    public ZipOutputStream newOutputStream(OutputStream os, Source source, DownloadContext context) {
        return new ZipOutputStream(os);
    }

    @SneakyThrows
    @Override
    public void beforeWrite(Part part, ZipOutputStream os) {
        os.putNextEntry(new ZipEntry(part.getPath()));
    }

    @SneakyThrows
    @Override
    public void afterWrite(Part part, ZipOutputStream os) {
        os.closeEntry();
    }

    @Override
    public String getSuffix() {
        return CompressFormat.ZIP_SUFFIX;
    }

    @Override
    public String getContentType() {
        return ContentType.Application.X_ZIP_COMPRESSED;
    }

    @Override
    public String getFormat() {
        return CompressFormat.ZIP;
    }
}
