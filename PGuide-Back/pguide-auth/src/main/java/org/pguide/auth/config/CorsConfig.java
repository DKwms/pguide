package org.pguide.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author DKwms
 * @Date 2023/9/21 21:06
 * @description
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    // 这里的auth合并进入网关，统一进行跨域配置，如果这里重复配置的话，会报错
    //@Override
    //public void addCorsMappings(CorsRegistry registry) {
    //    registry.addMapping("/**")
    //            //.allowedOrigins("*")  //注意这个变动项，这个是旧版
    //            .allowedOriginPatterns("*")//这个才是新版的要求
    //            .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
    //            .allowCredentials(true)
    //            .maxAge(3600)
    //            .allowedHeaders("*");
    //}
}
