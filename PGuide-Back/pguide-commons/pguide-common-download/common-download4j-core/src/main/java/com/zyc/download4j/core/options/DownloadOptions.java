package com.zyc.download4j.core.options;

import com.zyc.download4j.core.aop.annotation.CompressCache;
import com.zyc.download4j.core.aop.annotation.Download;
import com.zyc.download4j.core.aop.annotation.SourceCache;
import com.zyc.download4j.core.configuration.DownloadConfiguration;
import com.zyc.download4j.core.event.DownloadEventListener;
import lombok.Builder;
import lombok.Value;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载参数。
 *
 * @see Download
 * @see SourceCache
 * @see CompressCache
 */
@Value
@Builder(builderClassName = "Builder", toBuilder = true)
public class DownloadOptions {

    Object source;

    boolean sourceCacheEnabled;

    String sourceCachePath;

    boolean sourceCacheDelete;

    String filename;

    boolean inline;

    String contentType;

    String compressFormat;

    boolean forceCompress;

    boolean compressCacheEnabled;

    String compressCachePath;

    String compressCacheName;

    boolean compressCacheDelete;

    Charset charset;

    Map<String, String> headers;

    Object request;

    Object response;

    Object extra;

    DownloadMethod downloadMethod;

    DownloadEventListener eventListener;

    public static DownloadOptions from(DownloadConfiguration configuration) {
        return new Builder()
                .headers(configuration.getResponse().getHeaders())
                .sourceCacheEnabled(configuration.getSource().getCache().isEnabled())
                .sourceCachePath(configuration.getSource().getCache().getPath())
                .sourceCacheDelete(configuration.getSource().getCache().isDelete())
                .compressFormat(configuration.getCompress().getFormat())
                .compressCacheEnabled(configuration.getCompress().getCache().isEnabled())
                .compressCachePath(configuration.getCompress().getCache().getPath())
                .compressCacheDelete(configuration.getCompress().getCache().isDelete())
                .build();
    }

    public interface Rewriter {
        DownloadOptions rewrite(DownloadOptions options);
    }
}
