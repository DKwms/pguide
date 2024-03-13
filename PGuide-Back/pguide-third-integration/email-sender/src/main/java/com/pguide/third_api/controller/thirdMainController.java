package com.pguide.third_api.controller;

import com.pguide.third_api.service.emailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/8/13 21:46
 */
@Slf4j
@RestController
@RequestMapping("/third")
public class thirdMainController {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private emailSenderService emailsender;
    // 读取yml文件中的username的值并赋值给from

    /**
     * 发送纯文本邮箱验证码
     * @param to
     * @return
     */
    @GetMapping("emailsender")
    public Boolean emailSender(@RequestParam(value = "to") String to, HttpServletRequest request) {
        // 调用emailVerficationCode方法
        SimpleMailMessage message = emailsender.emailVerficationCode(to,request);
        // 发送邮件
        try {
            javaMailSender.send(message);
            log.info("发送成功");
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    /**
     * 发送html文件
     * @param to
     * @return
     */
    @GetMapping("/htmlsender")
    public Boolean htmlSender(@RequestParam(value = "to") String to, HttpServletRequest request) {
        MimeMessage htmled = emailsender.htmlVerficationCode(to,request);
        try {
            // 发送邮件
            javaMailSender.send(htmled);
            log.info("发送成功");
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }
}
