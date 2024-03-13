package org.pguide.auth.service;

import org.pguide.auth.controller.dto.SubSystemLoginDTO;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.auth.controller.vo.SubSystemLoginBody;
import org.pguide.common.core.result.JsonResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DKwms
 * @Date 2023/8/20 22:42
 * @description
 */
@Service
public interface LoginService {

    /**
     * 登录颁发凭证
     * @param loginBody
     * @return
     */
    String dologin(LoginBody loginBody, HttpServletRequest request);

    /**
     * 子系统重定向认证中心检测
     * 向子系统发送认证中心的位置
     * @param loginBody
     * @param request
     * @return
     */
    String sendAuthCenterUrl(LoginBody loginBody, HttpServletRequest request);

    /**
     * 子系统登录
     * @param loginBody
     * @param request
     * @return
     */
    JsonResult<SubSystemLoginDTO> doSubSystemLogin(SubSystemLoginBody loginBody, HttpServletRequest request);

    JsonResult<String> getTokenByCode(String tokenCode);
}
