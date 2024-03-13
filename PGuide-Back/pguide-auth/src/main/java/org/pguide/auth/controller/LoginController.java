package org.pguide.auth.controller;

import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.auth.service.LoginService;
import org.pguide.common.core.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DKwms
 * @Date 2023/8/20 22:37
 * @description
 */
@RequestMapping("/api/auth")
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;


    /**
     * 鉴权中心直接登录,一般不会使用这个方法，除非用户手动进入认证中心进行登录认证
     * return token
     */
    @PostMapping("/login")
    @ResponseBody
    public JsonResult login(@RequestBody LoginBody loginBody, HttpServletRequest request){
        String token = loginService.dologin(loginBody, request);
        return JsonResult.success("Login Success!",token);
    }



    /**
     * 子系统重定向到鉴权中心进行访问
     * @param loginBody
     * @return 重定向到目标网站，携带授权token
     */
    @PostMapping("/login/other")
    public String loginOther(@RequestBody LoginBody loginBody,HttpServletRequest request){
        String token = loginService.sendAuthCenterUrl(loginBody,request);
        // 重定向完整路径
        String redirectUrl = loginBody.getRedirectUrl();
        //TODO <safe>安全性考虑 重定向请求是否会被拦截，token是否容易被截获
        return "redirect:"+redirectUrl+"?token="+token;
    }

    /**
     *  注册接口，暂未开放
     * @return
     */
    @RequestMapping("/signup")
    @ResponseBody
    public JsonResult signup(){
        return null;
    }
}
