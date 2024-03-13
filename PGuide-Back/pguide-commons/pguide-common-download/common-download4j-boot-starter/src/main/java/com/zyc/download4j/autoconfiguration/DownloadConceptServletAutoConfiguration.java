package com.zyc.download4j.autoconfiguration;

import com.zyc.download4j.core.concept.DownloadReturnInterceptor;
import com.zyc.download4j.core.web.DownloadRequestProvider;
import com.zyc.download4j.core.web.DownloadResponseProvider;
import com.zyc.download4j.core.web.servlet.ServletDownloadRequestProvider;
import com.zyc.download4j.core.web.servlet.ServletDownloadResponseProvider;
import com.zyc.download4j.core.web.servlet.ServletDownloadReturnInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * Servlet 环境配置。
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(DownloadConceptCoreAutoConfiguration.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class DownloadConceptServletAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DownloadRequestProvider downloadRequestProvider() {
        return new ServletDownloadRequestProvider();
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadResponseProvider downloadResponseProvider() {
        return new ServletDownloadResponseProvider();
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadReturnInterceptor downloadReturnInterceptor() {
        return new ServletDownloadReturnInterceptor();
    }
}
