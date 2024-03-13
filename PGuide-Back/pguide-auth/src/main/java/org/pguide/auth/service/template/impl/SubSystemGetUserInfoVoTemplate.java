package org.pguide.auth.service.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.pguide.api.user.redis.SysUserRedisServer;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.auth.service.template.BaseStrategy;
import org.pguide.auth.service.template.BaseUserInfoModuleTemplate;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/20 17:01
 * @description 使用用户登录策略模板
 * 无封禁限制
 */
@Component
@Slf4j
public class SubSystemGetUserInfoVoTemplate extends BaseUserInfoModuleTemplate {

    // 策略类
    @Autowired
    List<BaseStrategy> strategies;

    @Autowired
    SysUserRedisServer sysUserRedisServer;

    @Override
    public UserInfoVo match(String systemType, String userType, LoginBody loginBody) {

        /**
         * TODO
         * 如果需要开启多系统开放配置，完善这里的代码
          */
        //Map<String, List<String>> suMap = sysUserRedisServer.getSystemTypeUserMap();
        //
        //List<String> userTypeList = suMap.getOrDefault(systemType,null);
        //if(userTypeList==null ||userTypeList.size() == 0){
        //    // 该类型系统被封禁
        //    return null;
        //}
        //if(!userTypeList.contains(userType)){
        //    // 该类型用户被封禁
        //    return null;
        //}



        // 匹配成功,系统允许放行

        for (BaseStrategy strategy : strategies)
        {
            if(strategy.match(systemType,userType))
            {
                return strategy.getUserInfoVo(loginBody);
            }
        }

        // 无执行策略符合，请求异常
        log.error("[pguide-auth-login]无用户种类，获取用户信息失败");
        return null;
    }
}
