package com.zyc.download4j.core.concept;

import com.zyc.download4j.core.options.DownloadOptions;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载处理的统一入口。
 */
public interface DownloadConcept {

    Object download(DownloadOptions options);
}
