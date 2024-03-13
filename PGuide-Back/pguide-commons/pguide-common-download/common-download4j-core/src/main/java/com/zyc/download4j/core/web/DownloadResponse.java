package com.zyc.download4j.core.web;

import lombok.SneakyThrows;
import reactor.core.publisher.Mono;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载响应。
 */
public interface DownloadResponse {

    default Mono<Void> write(Consumer<OutputStream> consumer) {
        consumer.accept(getOutputStream());
        return Mono.empty();
    }

    OutputStream getOutputStream();

    void setStatusCode(int statusCode);

    default void setAttachment(String filename) {
        setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encode(filename));
    }

    default void setInline(String filename) {
        setHeader("Content-Disposition", "inline; filename*=UTF-8''" + encode(filename));
    }

    @SneakyThrows
    default String encode(String s) {
        return URLEncoder.encode(String.valueOf(s), "UTF-8");
    }

    void setContentType(String contentType);

    void setContentLength(Long contentLength);

    default void setBytesAcceptRanges() {
        setHeader("Accept-Ranges", "bytes");
    }

    default void setContentRange(long start, long end, long total) {
        setHeader("Content-Range", "bytes " + start + "-" + end + "/" + total);
    }

    void setHeader(String name, String value);

    default void setHeaders(Map<String, String> headers) {
        if (headers == null) {
            return;
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            setHeader(entry.getKey(), entry.getValue());
        }
    }

    void addHeader(String name, String value);

    default void addHeaders(Map<String, String> headers) {
        if (headers == null) {
            return;
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            addHeader(entry.getKey(), entry.getValue());
        }
    }

    default void flush() {

    }
}
