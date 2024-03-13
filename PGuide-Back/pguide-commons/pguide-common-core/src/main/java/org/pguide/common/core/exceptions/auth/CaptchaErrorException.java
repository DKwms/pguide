package org.pguide.common.core.exceptions.auth;

import org.pguide.common.core.exceptions.AuthBaseException;
import org.pguide.common.core.constant.HttpStatus;

/**
 * @author DKwms
 * @Date 2023/9/19 21:10
 * @description
 */
public class CaptchaErrorException extends AuthBaseException {
    public CaptchaErrorException(){
        super("Captcha Error",HttpStatus.UNAUTHORIZED.value());
    }
}
