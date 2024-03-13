package org.pguide.auth.controller;

import org.pguide.auth.controller.dto.SubSystemLoginDTO;
import org.pguide.auth.controller.vo.SubSystemLoginBody;
import org.pguide.auth.service.LoginService;
import org.pguide.common.core.result.JsonResult;
import org.pguide.common.core.utils.RedirectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DKwms
 * @Date 2023/9/29 19:40
 * @description sub system login processor
 */
@RequestMapping("/api/auth")
@RestController
public class SubSystemLoginController {

    // 鉴权中心的前端nginx所属位置，需要返回认证中心的前端页面
    // TODO 后续更具不同的系统，动态导航到不同的登录页面中去，SPD|PGUIDE|LOKI 考虑使用不同的数据结构（MAP|SET）,配置文件导入

    @Value("${pguide.server.path.authPage}")
    private String authCenterUrl;

    @Autowired
    LoginService loginService;

    @GetMapping("/authCenter/redirect")
    public JsonResult toAuthCenter(String sendUrl, HttpServletResponse response){
        return RedirectHelper.doRedirectMemory(sendUrl,authCenterUrl,response);
    }

    /**
     * 子系统重定向到认证中心后进行登录，
     * 与认证中心自身登录不同，这里的登录vo多了一个tokenCode的属性，用于子系统在登录后换取token
     * @return
     */
    @PostMapping("/authCenter/login")
    public JsonResult<SubSystemLoginDTO> loginInAuthCenter(@RequestBody SubSystemLoginBody loginBody, HttpServletRequest request){
        return loginService.doSubSystemLogin(loginBody,request);
    }

    /**
     * 通过tokencode 换取token
     * 这里是子系统从定向回去后，拿自己localstorage里面的code进行token的取要
     */

    @GetMapping("/authCenter/tokenEx")
    public JsonResult<String> getTokenByCode(@RequestParam("tokenCode") String tokenCode){
        //TODO 这里需要ban掉短时间内重复请求的ip
        return loginService.getTokenByCode(tokenCode);
    }

}
