package org.pguide.mms.manage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2024/1/16 14:38
 * @description
 */
@Configuration
@MapperScan("org.pguide.**.mapper")
public class PguideBackMMSConfig {
}
