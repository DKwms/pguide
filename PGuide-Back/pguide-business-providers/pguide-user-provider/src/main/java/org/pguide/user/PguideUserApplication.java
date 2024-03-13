package org.pguide.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author DKwms
 * @Date 2023/12/30 19:40
 * @description
 */

@SpringBootApplication
@Slf4j
@EnableFeignClients(basePackages = {"org.pguide.api.**.feign"})
@EnableDiscoveryClient
public class PguideUserApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PguideUserApplication.class, args);
        log.info("项导用户中心启动成功！");
    }
}
