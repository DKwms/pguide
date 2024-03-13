package com.zyc.download4j.autoconfiguration;

import com.zyc.download4j.core.concept.DownloadReturnInterceptor;
import com.zyc.download4j.core.source.reactive.WebClientSourceFactory;
import com.zyc.download4j.core.web.DownloadRequestProvider;
import com.zyc.download4j.core.web.DownloadResponseProvider;
import com.zyc.download4j.core.web.reactive.ReactiveDownloadFilter;
import com.zyc.download4j.core.web.reactive.ReactiveDownloadRequestProvider;
import com.zyc.download4j.core.web.reactive.ReactiveDownloadResponseProvider;
import com.zyc.download4j.core.web.reactive.ReactiveDownloadReturnInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * Reactive 环境配置。
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(DownloadConceptCoreAutoConfiguration.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class DownloadConceptReactiveAutoConfiguration {

    @Bean
    public ReactiveDownloadFilter reactiveDownloadFilter() {
        return new ReactiveDownloadFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public WebClientSourceFactory webClientSourceFactory() {
        return new WebClientSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadRequestProvider downloadRequestProvider() {
        return new ReactiveDownloadRequestProvider();
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadResponseProvider downloadResponseProvider() {
        return new ReactiveDownloadResponseProvider();
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadReturnInterceptor downloadReturnInterceptor() {
        return new ReactiveDownloadReturnInterceptor();
    }
}
