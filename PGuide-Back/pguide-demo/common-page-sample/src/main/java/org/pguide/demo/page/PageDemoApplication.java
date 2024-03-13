package org.pguide.demo.page;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author DKwms
 * @Date 2024/2/6 17:02
 * @description
 */
@SpringBootApplication
@ComponentScan({"org.pguide.project.match.service","org.pguide.demo.page"})
@MapperScan("org.pguide.project.match.mapper")
public class PageDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PageDemoApplication.class, args);
    }
}
