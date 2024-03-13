package org.pguide.auth.service.template.impl.strategy;

import lombok.extern.slf4j.Slf4j;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.auth.service.template.BaseStrategy;
import org.pguide.common.security.constant.AuthConst;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.stereotype.Component;

/**
 * @Author DKwms
 * @Date 2024 01 2024/1/5 14 11
 */
@Component
@Slf4j
public class SubSystemSpdStrategy implements BaseStrategy {

    String SYS_TYPE = AuthConst.SystemTypeConst.PGUIDE_SPD;

    String USER_TYPE = AuthConst.UserTypeConst.PGUIDE_SPD_USER;

    @Override
    public boolean match(String systemType, String userType) {
        log.error("SPD系统暂未开放");
        return false;
    }

    @Override
    public void doAction(LoginBody loginBody) {

    }

    @Override
    public UserInfoVo getUserInfoVo(LoginBody loginBody) {
        return null;
    }

}
