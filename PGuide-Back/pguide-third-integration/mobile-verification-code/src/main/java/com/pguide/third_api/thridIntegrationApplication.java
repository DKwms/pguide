package com.pguide.third_api;

import com.pguide.third_api.entity.SmsStatic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/8/13 21:44
 */
@SpringBootApplication
@Slf4j
public class thridIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(thridIntegrationApplication.class);
        log.info("启动成功");
    }
}
