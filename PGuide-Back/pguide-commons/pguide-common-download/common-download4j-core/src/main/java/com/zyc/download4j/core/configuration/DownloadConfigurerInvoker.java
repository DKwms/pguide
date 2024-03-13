package com.zyc.download4j.core.configuration;

import lombok.Getter;

import java.util.Collection;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadConfigurer} 调用器。
 */
public class DownloadConfigurerInvoker {

    @Getter
    private final DownloadConfiguration configuration;

    public DownloadConfigurerInvoker(DownloadConfiguration configuration, Collection<DownloadConfigurer> configurers) {
        this.configuration = configuration;
        for (DownloadConfigurer it : configurers) {
            it.configure(configuration);
        }
    }
}
