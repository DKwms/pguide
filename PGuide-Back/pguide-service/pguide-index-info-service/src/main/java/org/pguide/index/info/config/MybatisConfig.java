package org.pguide.index.info.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2023/12/2 16:53
 * @description
 */

@MapperScan("org.pguide.entity.index.info.mapper")
@Configuration
public class MybatisConfig {
}
