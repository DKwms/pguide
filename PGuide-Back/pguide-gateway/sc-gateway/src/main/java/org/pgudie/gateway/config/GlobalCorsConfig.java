package org.pgudie.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author DKwms
 * @Date 2023/11/18 22:34
 * @description
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 这里仅为了说明问题，配置为放行所有域名，生产环境请对此进行修改
        config.addAllowedOriginPattern("*");
        // 放行的请求头
        config.addAllowedHeader("*");
        // 放行的请求方式，主要有：GET, POST, PUT, DELETE, OPTIONS
        config.addAllowedMethod("*");
        // 暴露头部信息
        config.addExposedHeader("*");
        // 是否发送cookie
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        HashSet<Object> objects = new HashSet<>();

        return new CorsWebFilter(source);
    }

}
