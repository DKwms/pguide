package org.pguide.competition.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author DKwms
 * @Date 2023 10 2023/10/9 16 28
 */

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
public class PguideCMSManageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PguideCMSManageApplication.class, args);
        log.info("项导cms系统启动成功！");
    }
}
