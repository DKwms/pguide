package org.pguide.mms.manage.controller.publish.es.utils;

import cn.hutool.core.lang.UUID;


/**
 * @Author DKwms
 * @Date 2024 02 2024/2/3 16 28
 *
 * uuid 生成工具
 */


public class UUIDUtil {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
    public static int getFastIntUUID(){
        String id =null;
        UUID uuid = UUID.fastUUID();
        id = uuid.toString();

        //去掉随机ID的短横线
        id = id.replace("-", "");

        //将随机ID换成数字
        int num = id.hashCode();
        //去绝对值
        return num < 0 ? -num : num;
    }

    public static int getRandomIntUUID(){
        String id =null;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();

        //去掉随机ID的短横线
        id = id.replace("-", "");

        //将随机ID换成数字
        int num = id.hashCode();
        //去绝对值
        return num < 0 ? -num : num;
    }


}
