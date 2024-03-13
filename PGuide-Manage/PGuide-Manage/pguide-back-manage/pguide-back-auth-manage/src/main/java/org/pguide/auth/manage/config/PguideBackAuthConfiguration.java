package org.pguide.auth.manage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2024/1/5 18:18
 * @description
 */

@Configuration
@MapperScan("org.pguide.**.mapper")
public class PguideBackAuthConfiguration {

}
