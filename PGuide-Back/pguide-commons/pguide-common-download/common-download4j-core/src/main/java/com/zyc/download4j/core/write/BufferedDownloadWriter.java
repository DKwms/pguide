package com.zyc.download4j.core.write;

import com.zyc.download4j.core.concept.Resource;
import com.zyc.download4j.core.context.DownloadContext;
import com.zyc.download4j.core.web.Range;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 使用缓冲区的写入器 / Writer using buffer
 * 默认缓冲区为1M / The default buffer is 1M
 */
@AllArgsConstructor
@NoArgsConstructor
public class BufferedDownloadWriter implements DownloadWriter {

    private int minBufferSize = 1024 * 1024;

    private int maxBufferSize = 8 * 1024 * 1024;

    @Override
    public boolean support(Resource resource, Range range, DownloadContext context) {
        return true;
    }

    @SneakyThrows
    @Override
    public void write(InputStream is, OutputStream os, Range range, Charset charset, Long length, Callback callback) {
        if (charset == null /*|| length > 0 && bufferSize >= length*/) {
            if (range == null) {
                write0(is, os, callback);
            } else {
                if (range.hasStart()) {
                    long skip = is.skip(range.getStart());
                }
                if (range.hasEnd()) {
                    long total = 0;
                    long l = range.getLength();
                    long current = 0;
                    byte[] bytes = new byte[minBufferSize];
                    int len;
                    while ((len = is.read(bytes)) > 0) {
                        if (total + len > l) {
                            long increase = l - total;
                            os.write(bytes, 0, (int) increase);
                            current += increase;
                            if (callback != null) {
                                callback.onWrite(current, increase);
                            }
                            break;
                        } else {
                            os.write(bytes, 0, len);
                            total += len;
                            current += len;
                            if (callback != null) {
                                callback.onWrite(current, len);
                            }
                        }
                        bytes = getBuffer(bytes, len);
                    }
                } else {
                    write0(is, os, callback);
                }
            }
        } else {
            InputStreamReader isr = new InputStreamReader(is, charset);
            BufferedReader br = new BufferedReader(isr, minBufferSize);
            int len;
            char[] chars = new char[minBufferSize];
            char[] result = new char[0];
            while ((len = br.read(chars)) > 0) {
                result = concat(result, chars, len);
            }
            String string = new String(result);
            byte[] bytes = string.getBytes(charset);
            if (callback != null) {
                callback.onWrite(bytes.length, bytes.length);
            }
            os.write(bytes);
        }
    }

    @SneakyThrows
    private void write0(InputStream is, OutputStream os, Callback callback) {
        long current = 0;
        byte[] bytes = new byte[minBufferSize];
        int len;
        while ((len = is.read(bytes)) > 0) {
            os.write(bytes, 0, len);
            current += len;
            if (callback != null) {
                callback.onWrite(current, len);
            }
            bytes = getBuffer(bytes, len);
        }
    }

    private byte[] getBuffer(byte[] buffer, int len) {
        int size = buffer.length;
        if (size == maxBufferSize) {
            return buffer;
        }
        if (len == size) {
            int newSize = size * 2;
            if (newSize > maxBufferSize) {
                return new byte[maxBufferSize];
            } else {
                return new byte[newSize];
            }
        } else {
            return buffer;
        }
    }

    private char[] concat(char[] current, char[] append, int length) {
        char[] newChars = new char[current.length + length];
        System.arraycopy(current, 0, newChars, 0, current.length);
        System.arraycopy(append, 0, newChars, current.length, length);
        return newChars;
    }
}
