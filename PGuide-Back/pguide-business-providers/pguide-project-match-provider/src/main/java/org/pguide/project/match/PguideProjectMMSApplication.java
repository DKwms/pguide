package org.pguide.project.match;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author DKwms
 * @Date 2024/1/29 15:25
 * @description
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
public class PguideProjectMMSApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PguideProjectMMSApplication.class, args);
    }
}
