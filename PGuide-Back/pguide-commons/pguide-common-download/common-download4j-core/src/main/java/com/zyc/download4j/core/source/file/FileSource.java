package com.zyc.download4j.core.source.file;

import com.zyc.download4j.core.concept.Part;
import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.source.AbstractSource;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.web.ContentType;
import lombok.*;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 持有 {@link File} 的 {@link Source}。
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileSource extends AbstractSource {

    @NonNull
    @Setter
    protected File file;

    protected Part part;

    @SneakyThrows
    @Override
    public InputStream openInputStream() {
        return file.isFile() ? new FileInputStream(file) : new EmptyInputStream();
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
        return length0(file);
    }

    private long length0(File file) {
        if (file.isFile()) {
            return file.length();
        } else {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return 0;
            }
            long length = 0;
            for (File f : files) {
                length += length0(f);
            }
            return length;
        }
    }

    @Override
    public boolean isSingle() {
        return file.isFile();
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
        return "FileSource(" + file.getAbsolutePath() + ")";
    }

    @Override
    public Collection<Part> getParts() {
        if (part != null) {
            part.release();
        }
        String name = getName();
        part = new FilePart(file, name, name);
        List<Part> parts = new ArrayList<>();
        Resource.addPart(part, parts);
        return parts;
    }

    @Override
    public void release() {
        super.release();
        if (part != null) {
            part.release();
            part = null;
        }
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends FileSource, B extends Builder<T, B>> extends AbstractSource.Builder<T, B> {

        private File file;

        public B file(File file) {
            this.file = file;
            return (B) this;
        }

        @Override
        protected T build(T target) {
            target.setFile(file);
            return super.build(target);
        }

        @Override
        public T build() {
            return build((T) new FileSource());
        }
    }
}
