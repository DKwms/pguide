package org.pguide.auth.service.template;

import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.user.entity.vo.UserInfoVo;

/**
 * @author DKwms
 * @Date 2024/1/20 17:05
 * @description
 */
public abstract class BaseUserInfoModuleTemplate {

    // 在模板实现类中，对策略进行遍历
    public abstract UserInfoVo match(String systemType, String userType, LoginBody loginBody);

    public UserInfoVo doLoginAction(String systemType, String userType, LoginBody loginBody){
        UserInfoVo userInfoVo = match(systemType, userType, loginBody);
        if(userInfoVo!=null){
            // 执行成功
            return userInfoVo;
        }
        return null;
    }
}
