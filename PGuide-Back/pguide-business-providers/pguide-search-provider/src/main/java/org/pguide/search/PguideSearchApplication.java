package org.pguide.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DKwms
 * @Date 2024/1/14 22:17
 * @description
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@Slf4j
public class PguideSearchApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PguideSearchApplication.class, args);
        log.info("PguideSeacrchAppliation 启动成功！");
    }
}
