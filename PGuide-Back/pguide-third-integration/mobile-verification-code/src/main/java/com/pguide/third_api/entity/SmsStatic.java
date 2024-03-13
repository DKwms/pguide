package com.pguide.third_api.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author sinahar
 * @version 1.0
 * @description: 手机验证部分
 * @date 2023/8/18 17:14
 */
public class SmsStatic {
    /**
     * 手机验证部分配置
     */
    // 设置超时时间-可自行调整
    public final static String defaultConnectTimeout  = "sun.net.client.defaultConnectTimeout";
    public final static String defaultReadTimeout = "sun.net.client.defaultReadTimeout";
    public final static String Timeout = "10000";
    // 初始化ascClient需要的几个参数
    public final static String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
    public final static String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
    // 替换成你的AK (产品密钥)
    @Value("${aliyun.send-msg.accessKeyId}")
    public static String accessKeyId ;// 你的accessKeyId,填你自己的 上文配置所得  自行配置
    @Value("${aliyun.send-msg.accessKeySecret}")
    public static String accessKeySecret ;// 你的accessKeySecret,填你自己的 上文配置所得 自行配置
    // 必填:短信签名-可在短信控制台中找到
    @Value("${aliyun.send-msg.SignName}")
    public static String SignName ;// 阿里云配置你自己的短信签名填入
    // 必填:短信模板-可在短信控制台中找到
    @Value("${aliyun.send-msg.TemplateCode}")
    public static String TemplateCode ; // 阿里云配置你自己的短信模板填入
}
