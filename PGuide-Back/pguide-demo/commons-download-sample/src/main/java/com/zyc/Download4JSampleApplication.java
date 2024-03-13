package com.zyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

/**
 * @author StevenZhang
 * @date 2023/9/28
 * @description
 */
@SpringBootApplication
public class Download4JSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Download4JSampleApplication.class, args);
        System.out.printf("Download4JSampleApplication 已于 %s 启动", new Date());
    }
}
