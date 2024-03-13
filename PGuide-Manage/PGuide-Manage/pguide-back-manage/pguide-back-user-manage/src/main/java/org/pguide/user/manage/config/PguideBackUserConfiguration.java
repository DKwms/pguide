package org.pguide.user.manage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2023/8/19 10:57
 * @description
 */

@Configuration
@MapperScan("org.pguide.**.mapper")
public class PguideBackUserConfiguration {
}
