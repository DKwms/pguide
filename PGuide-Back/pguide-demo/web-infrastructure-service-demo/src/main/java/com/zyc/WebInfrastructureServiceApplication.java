package com.zyc;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

/**
 * @author StevenZhang
 * @date 2023/8/15
 * @description -Xmx100m
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
public class WebInfrastructureServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebInfrastructureServiceApplication.class, args);
        if (log.isDebugEnabled()) {
            log.debug("WebInfrastructureServiceApplication Started At: {}", new Date());
        }
    }

}
