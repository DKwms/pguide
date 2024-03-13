package com.pguide.third_api.service.impl;

import com.pguide.third_api.service.emailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/8/13 22:06
 */
@Service
@Slf4j
public class emailSenderServiceImpl implements emailSenderService {

    @Resource
    private TemplateEngine engine;
    @Resource
    private JavaMailSender javaMailSender;

    // 读取yml文件中的username的值并赋值给from
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送纯文本验证码
     * @param to
     * @return  SimpleMailMessage
     */
    @Override
    public SimpleMailMessage emailVerficationCode(String to, HttpServletRequest request) {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送者
        message.setFrom(from);
        // 设置邮件接收者
        message.setTo(to);
        // 设置邮件的主题
        message.setSubject("验证码");
        // 设置邮件的内容
        String uuid = codeVerfication(UUID.randomUUID());
        String content = "尊敬的xxx,您好:\n" +
                "\n本次请求的邮件验证码为:"+uuid+",请勿泄露此验证码\n" +
                "\n如非本人操作，请忽略该邮件。\n(这是一封自动通过自动发送的邮件，请不要直接回复)";
        message.setText(content);
        return message;
    }

    /**
     * 发送html验证码
     * @param to
     * @return  MimeMessage
     */
    @Override
    public MimeMessage htmlVerficationCode(String to,HttpServletRequest request) {
        // 生产验证码
        String uuid = codeVerfication(UUID.randomUUID());
        // 创建邮件内容
        Context context = new Context();
        context.setVariable("message", Arrays.asList(uuid.split("")));

        // 将模块引擎解析成html字符串
        String process = engine.process("emailTemplate.html", context);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("验证码");
            helper.setText(process,true);
        } catch (Exception e) {
            log.info("邮件发送异常");
        }
        return mimeMessage;
    }

    /**
     * 生成验证码
     * @param uuid
     * @return
     */
    @Override
    public String codeVerfication(UUID uuid) {
        String code = uuid.toString().substring(0,5) ;
        return code;
    }
}
