package org.pguide.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2023/12/31 13:21
 * @description
 */
@Configuration
@MapperScan("org.pguide.user.mapper")
public class UserMybatisConfig {
}
