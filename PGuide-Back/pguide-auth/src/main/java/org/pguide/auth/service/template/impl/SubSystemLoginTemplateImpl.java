package org.pguide.auth.service.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.auth.service.template.BaseLoginModuleTemplate;
import org.pguide.auth.service.template.BaseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author DKwms
 * @Date 2024 01 2024/1/5 14 01
 */

@Component
@Slf4j
public class SubSystemLoginTemplateImpl extends BaseLoginModuleTemplate {



    // 策略类
    @Autowired
    List<BaseStrategy> strategies;

    @Override
    public boolean match(String systemType, String userType, LoginBody loginBody) {
        /**
         * TODO
         * 如果需要开启多系统开放配置，完善这里的代码
         */
        //Map<String, List<String>> suMap = sysUserRedisServer.getSystemTypeUserMap();
        //
        //List<String> userTypeList = suMap.getOrDefault(systemType,null);
        //if(userTypeList==null ||userTypeList.size() == 0){
        //    // 该类型系统被封禁
        //    return false;
        //}
        //if(!userTypeList.contains(userType)){
        //    // 该类型用户被封禁
        //    return false;
        //}
        // 模式二
        // 匹配成功,系统允许放行
        //if(userList!=null)
        //{
        //    main code。。。
        //}
        //else
        //{
        //    // 无系统或系统用户种类为0
        //    log.error("[pguide-auth-login]无系统用户种类，或系统用户被禁止登录，登录失败");
        //    return false;
        //}

        for (BaseStrategy strategy : strategies)
        {
            if(strategy.match(systemType,userType))
            {
                // 符合要求执行相关登录操作
                strategy.doAction(loginBody);
                return true;
            }
        }

        // 无执行策略符合，请求异常
        log.error("[pguide-auth-login]无用户种类，登录失败");
        return false;
    }
}
