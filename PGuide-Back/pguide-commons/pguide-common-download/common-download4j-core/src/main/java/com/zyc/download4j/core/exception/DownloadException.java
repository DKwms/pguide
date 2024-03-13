package com.zyc.download4j.core.exception;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载异常。
 */
public class DownloadException extends RuntimeException {

    public DownloadException(String message) {
        super(message);
    }

    public DownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadException(Throwable cause) {
        super(cause);
    }
}
