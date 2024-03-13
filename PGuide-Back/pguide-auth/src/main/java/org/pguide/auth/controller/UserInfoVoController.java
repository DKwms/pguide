package org.pguide.auth.controller;

import com.alibaba.nacos.shaded.com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.pguide.common.core.result.JsonResult;
import org.pguide.common.redis.constant.RedisConst;
import org.pguide.common.redis.service.RedisService;
import org.pguide.common.security.constant.AuthTokenConst;
import org.pguide.common.security.utils.JWTUtil;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DKwms
 * @Date 2024/1/21 11:25
 * @description
 */
@RequestMapping("/api/auth")
@RestController
@Slf4j
public class UserInfoVoController {

    @Autowired
    RedisService redisService;

    /**
     * 获取用户UserInfoVo
     * by token's uuid
     */
    @RequestMapping("/userinfo/vo")
    public JsonResult<UserInfoVo> getUserInfoVo(HttpServletRequest request){
        // pre check
        String token = request.getHeader(AuthTokenConst.TOKEN_HEADER);
        if(token==null){
            log.error("[UserInfoVo]换取异常，token为null，可能为爬虫或者网络攻击");
            JsonResult.error();
        }
        String uuid = JWTUtil.parseTokenToUUID(token);
        if(uuid==null || uuid.isEmpty()){
            log.error("[UserInfoVo]换取异常，token中未携带正确uuid，可能为爬虫或者网络攻击");
            JsonResult.error();
        }

        // getUserInfoVo
        UserInfoVo userInfoVo = (UserInfoVo)redisService.getObj(RedisConst.auth.TOKEN_USER_VO_KEY_REDIS+uuid);
        return JsonResult.success(userInfoVo);

    }
}
