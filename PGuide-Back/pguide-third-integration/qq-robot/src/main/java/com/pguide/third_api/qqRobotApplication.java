package com.pguide.third_api;

import lombok.extern.slf4j.Slf4j;
import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/8/15 13:49
 */
@EnableSimbot
@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class qqRobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(qqRobotApplication.class);
        log.info("机器人启动成功");
    }
}
