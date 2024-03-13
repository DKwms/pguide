package com.pguide.third_api.controller;

import com.pguide.third_api.service.SmsSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author sinahar
 * @version 1.0
 * @description: 短信发送
 * @date 2023/8/17 16:55
 */
@Slf4j
@RestController
@RequestMapping("sms")
@CrossOrigin //跨域请求
public class thirdApiMainController {

    @Resource
    private SmsSendService smsSendService;

    @PostMapping("/test")
    @ResponseBody
    public Object SmsVerification(@RequestParam("phone") String phone) {
        return smsSendService.SmsVerification(phone);
    }

}
