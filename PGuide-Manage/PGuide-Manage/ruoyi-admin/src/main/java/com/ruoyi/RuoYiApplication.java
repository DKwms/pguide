package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动程序;
 * @author ruoyi
 */

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class },scanBasePackages = {"com.ruoyi","com.pguide","org.pguide"})
//@EnableDiscoveryClient
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);

    }
}
