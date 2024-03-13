package org.pguide.studio.place.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DKwms
 * @Date 2023 10 2023/10/24 18 42
 */

@Configuration
@MapperScan("org.pguide.**.mapper")
@ComponentScan("org.pguide.studio.place")
public class StudioConfiguration {
}
