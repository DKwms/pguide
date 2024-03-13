package org.pguide.common.security.aspect.user;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.pguide.common.core.exceptions.auth.AuthKeyNotAllowException;
import org.pguide.common.security.annotation.UserAuth;
import org.pguide.common.security.constant.AuthConst;
import org.pguide.common.security.utils.AuthKeyUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @author DKwms
 * @Date 2024/1/31 12:53
 * @description
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class UserAuthAspect {



    /**
     * 权限模板：
     * 系统:用户 [最小级别]
     * 系统:*   [系统级别]
     * *:*     [无权限要求]
     */
    // 前置，检测当前用户是否 符合权限要求
    @Around("@annotation(auth)")
    public Object authTest(ProceedingJoinPoint joinPoint, UserAuth auth) throws Throwable {
        String authKey = auth.value();
        if(authKey==null || StringUtils.isEmpty(authKey)){
            authKey = auth.authKey();
            if(authKey==null || StringUtils.isEmpty(authKey)){
                // 只打了注解，没有值的，或者传的是空值的，直接报错
                log.error("打了注解，但是注解没有填参数，这个异常不该出现，出现了就好好检查，哪一个@UserAuth忘填参数了！");
                throw new AuthKeyNotAllowException();
            }
        }

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();

        // 获取请求体 request
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        String requestAuthKey = request.getHeader(AuthConst.AspectAuthKeyConst.SYS_USER_AUTH_KEY_IN_HEADER);

        log.debug("该请求权限关键字：{}",authKey);
        log.debug("用户权限：{}",requestAuthKey);

        // 白名单权限
        if(!AuthConst.AspectAuthKeyConst.FULL_AUTH_VALUE.equals(requestAuthKey)) {
            // 权限匹配
            if(!AuthKeyUtil.checkAuthKeyValue(authKey, requestAuthKey)){
                // 登录失败异常
                throw new AuthKeyNotAllowException();
            }
        }

        return joinPoint.proceed();
    }



}
