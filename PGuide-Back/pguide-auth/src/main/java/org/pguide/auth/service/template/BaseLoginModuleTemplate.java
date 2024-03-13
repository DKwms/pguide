package org.pguide.auth.service.template;

import org.pguide.auth.controller.vo.LoginBody;

/**
 * @Author DKwms
 * @Date 2024 01 2024/1/5 13 44
 * @description
 */
public abstract class BaseLoginModuleTemplate {

    // 在模板实现类中，对策略进行遍历
    public abstract boolean match(String systemType, String userType, LoginBody loginBody);

    public boolean doLoginAction(String systemType,String userType,LoginBody loginBody){
        if(match(systemType,userType,loginBody)){
            // 执行成功
            return true;
        }
        return false;
    }


}
