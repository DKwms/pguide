package org.pguide.common.security.constant;

/**
 * @author DKwms
 * @Date 2023/10/5 17:43
 * @description jwt body中的key值常量
 */
public interface JWTClaimsKeyConstants {

    /**
     * JWT 中uuid的key，用于获取jwt中用户uuid
     */
    String UUID_KEY = "PGUIDE_JWT_UUID_key";
}
