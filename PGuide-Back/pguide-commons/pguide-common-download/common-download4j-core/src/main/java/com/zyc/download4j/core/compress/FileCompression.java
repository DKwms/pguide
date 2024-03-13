package com.zyc.download4j.core.compress;

import com.zyc.download4j.core.web.ContentType;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 文件压缩。
 */
@AllArgsConstructor
public class FileCompression extends AbstractCompression {

    @NonNull
    protected final File file;

    @SneakyThrows
    @Override
    public InputStream openInputStream() {
        return new FileInputStream(file);
    }

    @Override
    public String getName() {
        String name = super.getName();
        if (!StringUtils.hasText(name)) {
            setName(file.getName());
        }
        return super.getName();
    }

    @Override
    public String getContentType() {
        String contentType = super.getContentType();
        if (!StringUtils.hasText(contentType)) {
            setContentType(ContentType.file(file));
        }
        return super.getContentType();
    }

    @Override
    public Long getLength() {
        return file.length();
    }

    @Override
    public boolean isCacheEnabled() {
        return true;
    }

    @Override
    public boolean isCacheExisted() {
        return file.exists();
    }

    @Override
    public String getCachePath() {
        return file.getParent();
    }

    @Override
    public String getDescription() {
        return "FileCompression(" + file.getAbsolutePath() + ")";
    }

    @Override
    public void deleteCache() {
        if (isCacheEnabled() && isCacheExisted()) {
            boolean delete = file.delete();
        }
    }
}
