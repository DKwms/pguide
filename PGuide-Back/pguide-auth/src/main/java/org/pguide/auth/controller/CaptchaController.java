package org.pguide.auth.controller;

import org.checkerframework.checker.lock.qual.ReleasesNoLocks;
import org.pguide.auth.service.CaptchSerivce;
import org.pguide.auth.service.impl.CaptchServiceImpl;
import org.pguide.common.core.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DKwms
 * @Date 2023/8/20 22:41
 * @description
 */
@RestController
@RequestMapping("/api/auth")
public class CaptchaController {

    @Autowired
    CaptchServiceImpl captchService;

    /**
     * 获取验证码
     * @return uuid img(base64)
     */
    @RequestMapping("getCaptch")
    public JsonResult getCaptch(){
        return captchService.doGetCaptch();
    }



    /**
     * 检验验证码
     * @param uuid
     * @param code
     * @return "true"
     */
    @RequestMapping("/checkCaptch")
    public JsonResult checkCatch(String uuid,String code){
        return captchService.doCheckCaptch(uuid,code);
    }
}
