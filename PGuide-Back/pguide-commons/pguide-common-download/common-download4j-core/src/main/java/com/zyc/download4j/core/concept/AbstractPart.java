package com.zyc.download4j.core.concept;

import java.io.InputStream;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link Part} 的抽象类。
 */
public abstract class AbstractPart implements Part {

    protected InputStream inputStream;

    @Override
    public InputStream getInputStream() {
        if (inputStream == null) {
            inputStream = openInputStream();
        }
        return inputStream;
    }

    public abstract InputStream openInputStream();

    @Override
    public void release() {
        getChildren().forEach(Part::release);
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable ignore) {
            }
            inputStream = null;
        }
    }
}
