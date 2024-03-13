package org.pgudie.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLOutput;

/**
 * @author DKwms
 * @Date 2023/8/23 17:51
 * @description
 */
@SpringBootApplication
@Slf4j
public class GateWayApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(GateWayApplication.class);

        log.info("\n"+
                " ____     ____           _       _        \n" +
                "|  _ \\   / ___|  _   _  (_)   __| |   ___ \n" +
                "| |_) | | |  _  | | | | | |  / _` |  / _ \\\n" +
                "|  __/  | |_| | | |_| | | | | (_| | |  __/\n" +
                "|_|      \\____|  \\__,_| |_|  \\__,_|  \\___|\n" +
                "                                          ");

        log.info("PGuide 网关启动成功！");
    }
}
