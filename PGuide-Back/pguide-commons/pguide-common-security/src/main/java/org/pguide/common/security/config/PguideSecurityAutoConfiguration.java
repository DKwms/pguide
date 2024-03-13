package org.pguide.common.security.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author DKwms
 * @Date 2024/2/1 21:40
 * @description
 */
@Configuration
@ComponentScan("org.pguide.common.security")
@EnableAspectJAutoProxy
public class PguideSecurityAutoConfiguration {
}
