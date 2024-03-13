package org.pguide.auth.service.template;

import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.user.entity.vo.UserInfoVo;

/**
 * @Author DKwms
 * @Date 2024 01 2024/1/5 13 58
 */
public interface BaseStrategy {

    /**
     * 匹配策略
     * @param systemType 系统类型
     * @param userType  用户类型
     * @return ifTrue 策略匹配成功，将执行登录方法
     */
    public boolean match(String systemType, String userType);

    /**
     * 执行策略
     * 执行登录方法
     */
    public void doAction(LoginBody loginBody);

    /**
     * 执行拼接vo方法
     */
    UserInfoVo getUserInfoVo(LoginBody loginBody);

}
