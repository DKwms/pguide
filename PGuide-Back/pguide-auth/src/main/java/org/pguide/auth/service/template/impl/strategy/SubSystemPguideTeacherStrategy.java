package org.pguide.auth.service.template.impl.strategy;

import lombok.extern.slf4j.Slf4j;
import org.pguide.api.user.feign.UserCenterGetTeacherInfoClient;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.common.core.exceptions.auth.LoginErrorException;
import org.pguide.auth.service.template.BaseStrategy;
import org.pguide.common.security.constant.AuthConst;
import org.pguide.user.entity.UsercenterTeacherInfo;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author DKwms
 * @Date 2024 01 2024/1/5 15 17
 *
 * 向导系统老师登录
 */
@Slf4j
@Component
public class SubSystemPguideTeacherStrategy implements BaseStrategy {

    @Autowired
    UserCenterGetTeacherInfoClient userCenterGetTeacherInfoClient;

    String SYS_TYPE = AuthConst.SystemTypeConst.PGUIDE;

    String USER_TYPE = AuthConst.UserTypeConst.PGUIDE_TEACHERROR;

    @Override
    public boolean match(String systemType, String userType) {
        if(SYS_TYPE.equals(systemType) && USER_TYPE.equals(userType)) return true;
        return false;
    }

    @Override
    public void doAction(LoginBody loginBody) {
        log.info("[登录处理<passwordCheck>]:PGuide-Teacher 登录");

        //TODO 细化登录类型
        String account = loginBody.getAccount();

        UsercenterTeacherInfo data = userCenterGetTeacherInfoClient.getTeacherInfoByAccount(account).getData();

        // 补充loginBody信息
        loginBody.setWorkSpace(data.getTeacherUnit());
        loginBody.setWorkDept(data.getTeacherAcademy());
        loginBody.setUserName(data.getTeacherNick());
        loginBody.setUserId(data.getTeacherId());
        loginBody.setWorkId(data.getWorkId());


        //TODO 细化登录异常种类
        if(data==null || data.getTeacherPassword()==null || !data.getTeacherPassword().equals(loginBody.getPassword())){
            throw new LoginErrorException();
        }
    }

    @Override
    public UserInfoVo getUserInfoVo(LoginBody loginBody) {
        UserInfoVo userInfoVo = UserInfoVo.builder()
                .userName(loginBody.getUserName())
                .userAcademy(loginBody.getWorkDept())
                .userSchool(loginBody.getWorkSpace())
                .userType(loginBody.getUserType())
                .userAccount(loginBody.getAccount())
                .workId(loginBody.getWorkId())
                .userId(loginBody.getUserId())
                //TODO 项目系统，关联用户账户
                .userGroup(null)
                .build();
        System.out.println(userInfoVo);
        return userInfoVo;
    }


}
