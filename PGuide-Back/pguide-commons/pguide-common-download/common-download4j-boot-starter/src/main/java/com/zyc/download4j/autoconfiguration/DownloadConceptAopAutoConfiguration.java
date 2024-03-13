package com.zyc.download4j.autoconfiguration;

import com.zyc.download4j.core.aop.advice.DownloadConceptAdvice;
import org.springframework.aop.Advisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * AOP配置。
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(DownloadConceptAdvice.class)
public class DownloadConceptAopAutoConfiguration {

    @Bean
    @ConditionalOnClass(Advisor.class)
    public DownloadConceptAdvice downloadConceptAdvice() {
        return new DownloadConceptAdvice();
    }
}
