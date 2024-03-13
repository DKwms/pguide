package org.pguide.common.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author DKwms
 * @Date 2024/2/1 21:18
 * @description
 */

@Configuration
//扫描异常处理
@ComponentScan("org.pguide.common.core.handler")
public class PguideCommonAutoConfiguration {

}
