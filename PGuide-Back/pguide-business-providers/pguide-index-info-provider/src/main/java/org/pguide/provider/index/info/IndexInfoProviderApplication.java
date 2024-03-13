package org.pguide.provider.index.info;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

/**
 * @author DKwms
 * @Date 2023/11/20 22:07
 * @description
 */

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class IndexInfoProviderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IndexInfoProviderApplication.class, args);
        log.info(String.valueOf(LocalDateTime.now()));
    }
}

