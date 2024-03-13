package org.pguide.mms.manage.controller.publish.es.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author DKwms
 * @Date 2024/1/23 13:26
 * @description
 */

@Slf4j
public class ESJsonUtil {

    public static String parseObjToJSONWithUnderscore(Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE); // 驼峰转下划线

        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json序列化失败");
            throw new RuntimeException(e);
        }

        return json;

    }
}
