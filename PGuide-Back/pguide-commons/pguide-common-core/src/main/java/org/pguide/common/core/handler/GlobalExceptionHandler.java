package org.pguide.common.core.handler;

import org.pguide.common.core.exceptions.AuthBaseException;
import org.pguide.common.core.exceptions.auth.AuthKeyNotAllowException;
import org.pguide.common.core.exceptions.auth.CaptchaErrorException;
import org.pguide.common.core.exceptions.auth.CaptchaExpireException;
import org.pguide.common.core.exceptions.auth.LoginErrorException;
import org.pguide.common.core.result.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author DKwms
 * @Date 2023/9/19 22:02
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 权限校验异常捕获,<br>
     * 一般由业务系统抛出
     */
    @ExceptionHandler(AuthKeyNotAllowException.class)
    public JsonResult handleAuthKeyNotAllowException(AuthKeyNotAllowException e){
        return JsonResult.error(e.getCode(),e.getMessage());
    }

    /**
     * 验证码错误捕获
     */
    @ExceptionHandler(CaptchaErrorException.class)
    public JsonResult handleCaptchaErrorException(CaptchaErrorException e){
        return JsonResult.error(e.getCode(),e.getMessage());
    }

    /**
     * 验证码超时异常捕获
     */
    @ExceptionHandler(CaptchaExpireException.class)
    public JsonResult handleCaptchaExpireException(CaptchaExpireException e){
        return JsonResult.error(e.getCode(),e.getMessage());
    }

    /**
     * 登录异常
     */
    @ExceptionHandler
    public JsonResult handleLoginErrorException(LoginErrorException e){
        return JsonResult.error(e.getCode(),e.getMessage());
    }

    /**
     * auth 异常，未处理
     */
    @ExceptionHandler
    public JsonResult handleAuthBaseException(AuthBaseException e){
        return JsonResult.error(e.getCode(),e.getMessage());
    }

    /**
     * 未知异常
     */
    @ExceptionHandler
    public JsonResult handleException(RuntimeException e){
        //TODO 前端对未知异常做一个单独页面显示
        e.printStackTrace();
        return JsonResult.error(500,"<h1>有一个未知异常发生，很抱歉，这个问题本不应该出现<h1>\n"+e.getMessage());
    }


}
