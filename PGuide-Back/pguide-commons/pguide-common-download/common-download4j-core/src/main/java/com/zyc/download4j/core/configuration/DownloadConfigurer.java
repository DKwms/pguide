package com.zyc.download4j.core.configuration;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadConfiguration} 的配置器。
 * 可以在代码中修改全局默认配置。
 */
public interface DownloadConfigurer {

    void configure(DownloadConfiguration configuration);
}
