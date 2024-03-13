package com.pguide.third_api.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.pguide.third_api.entity.SmsStatic;
import com.pguide.third_api.service.SmsSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @Description: 阿里云短信接口配置类
 * @author: yangxf
 * @date: 2019/4/11 15:01
 */
@Service
@Slf4j
public class SmsSendServiceImpl implements SmsSendService {

    /**
     * @param phone
     * @return
     * @throws ClientException
     */
    @Override
    public SendSmsResponse sendSms(String phone) throws ClientException {

        /**
         * 进行正则关系校验
         */
        System.out.println(phone);
        if (phone == null || phone == "") {
            System.out.println("手机号为空");
        }
        
        // 设置超时时间-可自行调整
        System.setProperty(SmsStatic.defaultConnectTimeout, SmsStatic.Timeout);
        System.setProperty(SmsStatic.defaultReadTimeout, SmsStatic.Timeout);
        // 初始化ascClient需要的几个参数
        final String product = SmsStatic.product;// 短信API产品名称（短信产品名固定，无需修改）
        final String domain = SmsStatic.domain;// 短信API产品域名（接口地址固定，无需修改）
        // 替换成你的AK
        final String accessKeyId = SmsStatic.accessKeyId;// 你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = SmsStatic.accessKeySecret;// 你的accessKeySecret，参考本文档步骤2
        // 初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
                    domain);
        } catch (ClientException e1) {
            e1.printStackTrace();
        }

        // 获取验证码
        String uuid = codeVerfication(UUID.randomUUID());


        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        // 使用post提交
        request.setMethod(MethodType.POST);
        // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(phone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(SmsStatic.SignName);
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(SmsStatic.TemplateCode);
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        // 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{ \"code\":\""+uuid+"\"}");
        // 可选-上行短信扩展码(无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");
        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        // 请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null
                    && sendSmsResponse.getCode().equals("OK")) {
                // 请求成功
                System.out.println("获取验证码成功！！！");
            } else {
                //如果验证码出错，会输出错误码告诉你具体原因
                System.out.println(sendSmsResponse.getCode());
                System.out.println("获取验证码失败...");
            }
        } catch (ServerException e) {
            log.error(e.getMessage());
        } catch (ClientException e) {
            log.error(e.getMessage());
        }
        return sendSmsResponse;
    }

    /**
     * @Function: 短信验证
     * @Date:     2019/4/11 15:56
     * @param:    phone 手机号
     */
    @Override
    public Map<String, Object> SmsVerification(String phone) {
        Map<String, Object> map = new HashMap<>();
        try {
            sendSms(phone);
            map.put("code", 200);
            map.put("msg", "短信验证发送成功");
            return map;
        } catch (ClientException e) {
            map.put("code", 300);
            map.put("msg", e.getMessage());
            return map;
        }
    }

    /**
     * 发送验证码
     * @param uuid
     * @return
     */
    @Override
    public String codeVerfication(UUID uuid) {
        String code = uuid.toString().substring(0,5);
        return code;
    }
}


