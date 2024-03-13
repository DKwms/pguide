package com.pguide.third_api.service;

import org.springframework.mail.SimpleMailMessage;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/8/13 22:05
 */
public interface emailSenderService {

    /**
     * 发送邮箱验证码
     * @param to
     * @return
     */
    SimpleMailMessage emailVerficationCode(String to, HttpServletRequest request);

    /**
     * 发送html邮件验证码
     * @param to
     * @return
     */
    MimeMessage htmlVerficationCode(String to,HttpServletRequest request);

    String codeVerfication(UUID uuid);

}
