package com.pguide.third_api.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import java.util.Map;
import java.util.UUID;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/8/17 16:37
 */
public interface SmsSendService {

    /**
     * @param phone
     * @return
     * @throws ClientException
     */
    SendSmsResponse sendSms(String phone) throws ClientException;

    /**
     * @param phone
     * @return
     */
    Map<String, Object> SmsVerification(String phone);

    String codeVerfication(UUID uuid);
}
