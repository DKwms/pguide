package org.pguide.common.redis.constant;

/**
 * @Author DKwms
 * @Date 2023 09 2023/9/21 16 22
 */
public interface RedisConst {

    /**
     * 鉴权系统redis key
     */
    interface auth{
        /**
         * redis 中token对于用户信息的前缀<br>
         * 后面加 jwt中的uuid<br>
         * return userinfovo
         */
        String TOKEN_USER_VO_KEY_REDIS = "PGUIDE_TOKEN_";

        /**
         * redis 中缓存子系统token<br>
         * 后面加 tokencode<br>
         * return token
         */
        String PGUIDE_TOKEN_CODE = "PGUIDE_TOKEN_CODE_";

        /**
         * jwt 中token对于key
         */
        String TOKEN_KEY_JWT = "PGUIDE_JWT_TOKEN_KEY";

    }

    interface user{

    }

    interface cms{

    }


}
