package org.pguide.mms.manage.controller.publish.es.listener;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * @author DKwms
 * @Date 2024/1/23 10:47
 * @description
 */
@Configuration
@Slf4j
public class ApplicationCloseListener {

    @Autowired
    RestHighLevelClient client;

    @PreDestroy
    public void closeEs(){
        try {
            client.close();
            log.info("es服务关闭");
        } catch (IOException e) {
            log.error("es服务关闭异常！");
            throw new RuntimeException(e);
        }
    }
}
