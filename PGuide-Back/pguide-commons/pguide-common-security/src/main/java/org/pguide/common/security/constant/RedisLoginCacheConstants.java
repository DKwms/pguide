package org.pguide.common.security.constant;

/**
 * 缓存的key 常量
 * 
 * @author DKwms
 */
public interface RedisLoginCacheConstants
{
    /**
     * 登录用户 redis key
     */
    String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码 redis key
     */
    String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码过期时间
     */
    Integer CAPTCHA_EXPIRATION = 1;


}
