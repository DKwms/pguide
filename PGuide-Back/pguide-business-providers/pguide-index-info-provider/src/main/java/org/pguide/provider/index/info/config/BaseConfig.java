package org.pguide.provider.index.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2023/11/23 10:36
 * @description
 */

@Configuration
@ComponentScans(value = {
        @ComponentScan("org.pguide.provider.index.info.**"),
        @ComponentScan("org.pguide.entity.index.info")
})
public class BaseConfig {

}
