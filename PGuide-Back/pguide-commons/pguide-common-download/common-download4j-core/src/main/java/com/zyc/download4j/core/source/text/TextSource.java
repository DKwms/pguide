package com.zyc.download4j.core.source.text;

import com.zyc.download4j.core.source.AbstractSource;
import com.zyc.download4j.core.source.Source;
import com.zyc.download4j.core.web.ContentType;
import lombok.*;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 支持一段文本的 {@link Source}。
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TextSource extends AbstractSource {

    @NonNull
    @Setter(AccessLevel.PROTECTED)
    protected String text;

    protected byte[] bytes;

    @Override
    public InputStream openInputStream() {
        return new ByteArrayInputStream(getBytes());
    }

    @Override
    public String getContentType() {
        String contentType = super.getContentType();
        if (!StringUtils.hasText(contentType)) {
            setContentType(ContentType.Text.PLAIN);
        }
        return super.getContentType();
    }

    @Override
    public Long getLength() {
        return (long) getBytes().length;
    }

    public byte[] getBytes() {
        if (bytes == null) {
            Charset charset = getCharset();
            bytes = charset == null ? text.getBytes() : text.getBytes(charset);
        }
        return bytes;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getDescription() {
        return "TextSource(" + text + ")";
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends TextSource, B extends Builder<T, B>> extends AbstractSource.Builder<T, B> {

        private String text;

        public B text(String text) {
            this.text = text;
            return (B) this;
        }

        @Override
        protected T build(T target) {
            target.setText(text);
            return super.build(target);
        }

        @Override
        public T build() {
            return build((T) new TextSource());
        }
    }
}
