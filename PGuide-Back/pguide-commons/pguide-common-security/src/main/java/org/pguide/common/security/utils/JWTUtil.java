package org.pguide.common.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.pguide.common.security.constant.JWTClaimsKeyConstants;

import java.util.HashMap;

/**
 * @author DKwms
 * @Date 2023/9/19 20:42
 * @description
 */

public class JWTUtil {

    private static String TOKEN_SECRET = "eianfnejedkaekajjejdfiiea";

    /**
     * 通过hashmap进行存储，放入body进行加密
     * @param claims 信息的map
     */
    public static String createToken(HashMap<String,Object> claims){
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,TOKEN_SECRET).compact();
    }

    /**
     * 返回token中的uuid，关联用户信息
     * @param token 生成授权token，后面通过header进行传播。
     */
    public static String parseTokenToUUID(String token){
        Claims claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
        return (String)claims.getOrDefault(JWTClaimsKeyConstants.UUID_KEY, null);
    }



}
