package org.pguide.common.security.utils;

import org.pguide.common.security.constant.AuthTokenConst;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DKwms
 * @Date 2024/1/29 16:44
 * @description 快速获取token和uuid工具类
 */
public class TokenUtil {

    public static String getToken(HttpServletRequest request){
        return request.getHeader(AuthTokenConst.TOKEN_HEADER);
    }

    public static String getUUIDInToken(HttpServletRequest request){
        String token = request.getHeader(AuthTokenConst.TOKEN_HEADER);
        return JWTUtil.parseTokenToUUID(token);
    }

    public static String getUUIDInToken(String token){
        return JWTUtil.parseTokenToUUID(token);
    }
}
