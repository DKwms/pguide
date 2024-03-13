package org.pguide.api.user.redis;

import org.pguide.common.redis.constant.RedisConst;
import org.pguide.common.redis.service.RedisService;
import org.pguide.common.security.constant.AuthTokenConst;
import org.pguide.common.security.utils.TokenUtil;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DKwms
 * @Date 2024/1/30 14:22
 * @description
 */
@Service
public class UserInfoRedisServer {

    @Autowired
    RedisService redisService;

    /**
     * get userInfo in redis by uuid,
     * contain user's basic info
     */
    public UserInfoVo getUserInfo(String uuid){
         return (UserInfoVo) redisService.getObj(RedisConst.auth.TOKEN_USER_VO_KEY_REDIS+uuid);
    }
    // get uuid from token
    public UserInfoVo getUserInfoByToken(String token){
        String uuid = TokenUtil.getUUIDInToken(token);
        System.out.println(uuid);
        return (UserInfoVo) redisService.getObj(RedisConst.auth.TOKEN_USER_VO_KEY_REDIS+uuid);
    }

    //get by request's header
    public UserInfoVo getUserInfo(HttpServletRequest request){
        String token = request.getHeader(AuthTokenConst.TOKEN_HEADER);
        return getUserInfoByToken(token);
    }

    //TODO get by theadLocal
    public UserInfoVo getUserInfo(){
        return null;
    }
}
