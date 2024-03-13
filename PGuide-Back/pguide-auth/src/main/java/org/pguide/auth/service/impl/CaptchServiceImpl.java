package org.pguide.auth.service.impl;

import com.google.code.kaptcha.Producer;
import org.pguide.common.security.constant.RedisLoginCacheConstants;
import org.pguide.auth.service.CaptchSerivce;
import org.pguide.auth.utils.Base64;
import org.pguide.common.core.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.FastByteArrayOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author DKwms
 * @Date 2023/8/20 22:43
 * @description
 */

@Service
public class CaptchServiceImpl implements CaptchSerivce {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    RedisTemplate redisTemplate;

    public JsonResult doGetCaptch() {
        // 保存验证码信息
        String uuid = UUID.randomUUID().toString();
        String verifyKey = RedisLoginCacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null;
        BufferedImage image = null;

        /** 计算类型
         *             String capText = captchaProducerMath.createText();
         *             capStr = capText.substring(0, capText.lastIndexOf("@"));
         *             code = capText.substring(capText.lastIndexOf("@") + 1);
         *             image = captchaProducerMath.createImage(capStr);
         */

        capStr = captchaProducer.createText();
        image = captchaProducer.createImage(capStr);

        //TODO 暂时先用redistemplate,默认缓存一分钟
        redisTemplate.opsForValue().set(verifyKey, capStr, RedisLoginCacheConstants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);


        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return JsonResult.error(e.getMessage());
        }


        return JsonResult.success(new HashMap<String,Object>(){{
            this.put("uuid",uuid);
            this.put("img", Base64.encode(os.toByteArray()));
        }});
    }


    public JsonResult doCheckCaptch(String uuid,String code){
        //TODO 暂时先用redistemplate取验证码
        String rowCode = (String)redisTemplate.opsForValue().get(RedisLoginCacheConstants.CAPTCHA_CODE_KEY + uuid);

        if (rowCode==null)
            return JsonResult.error("验证码过期");

        if (!rowCode.equals(code)) return JsonResult.error("验证码错误");


        return JsonResult.success("校验成功","true");
    }
}
