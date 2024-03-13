package com.zyc.config;

import com.zyc.download4j.core.configuration.DownloadConfigurer;
import org.springframework.context.annotation.Configuration;

/**
 * @author StevenZhang
 * @date 2023/10/3
 * @description
 */
@Configuration(proxyBeanMethods = false)
public class DownloadConfiguration implements DownloadConfigurer {

    @Override
    public void configure(com.zyc.download4j.core.configuration.DownloadConfiguration configuration) {
        //可以进行配置更新
    }

    //WebFlux Mono
    //@Bean
    //public SchedulerSourceLoader schedulerSourceLoader() {
    //    return new SchedulerSourceLoader(Schedulers.fromExecutor(Executors.newFixedThreadPool(3)));
    //}

}
