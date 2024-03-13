package org.pguide.auth.service.template.impl.strategy;


import lombok.extern.slf4j.Slf4j;
import org.pguide.api.user.feign.UserCenterGetStudentInfoClient;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.common.core.exceptions.auth.LoginErrorException;
import org.pguide.auth.service.template.BaseStrategy;
import org.pguide.common.security.constant.AuthConst;
import org.pguide.user.entity.UsercenterStudentInfo;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author DKwms
 * @Date 2024 01 2024/1/5 14 10
 *
 * 向导系统学生登录
 */

@Component
@Slf4j
public class SubSystemPguideStudentStrategy implements BaseStrategy {

    @Autowired
    UserCenterGetStudentInfoClient userCenterGetStudentInfoClient;

    String SYS_TYPE = AuthConst.SystemTypeConst.PGUIDE;

    String USER_TYPE = AuthConst.UserTypeConst.PGUIDE_STUDENT;

    @Override
    public boolean match(String systemType, String userType) {
        if(SYS_TYPE.equals(systemType) && USER_TYPE.equals(userType)) return true;
        return false;
    }

    @Override
    public void doAction(LoginBody loginBody) {
        log.info("[登录处理<passwordCheck>]:PGuide-Student 登录");
        // 学生端登录
        //TODO 细化登录类型
        String account = loginBody.getAccount();
        UsercenterStudentInfo data = userCenterGetStudentInfoClient.getStudentInfoByAccount(account).getData();
        //TODO 细化登录异常种类

        loginBody.setWorkSpace(data.getStudentSchool());
        loginBody.setWorkDept(data.getStudentAcademy());
        loginBody.setStudentYear(data.getStudentYear());
        loginBody.setUserName(data.getStudentNick());
        loginBody.setUserId(data.getStudentId());
        loginBody.setWorkId(data.getWorkId());

        if(data==null || data.getStudentPassword()==null || !data.getStudentPassword().equals(loginBody.getPassword())){
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
                .studentYear(loginBody.getStudentYear())
                //TODO 项目系统，关联用户账户
                .userGroup(null)
                .build();
        System.out.println(userInfoVo);
        return userInfoVo;
    }


}
