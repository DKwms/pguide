package org.pguide.common.core.exceptions.auth;

import org.pguide.common.core.exceptions.AuthBaseException;
import org.pguide.common.core.constant.HttpStatus;

/**
 * @author DKwms
 * @Date 2023/9/19 21:23
 * @description
 */
public class CaptchaExpireException extends AuthBaseException {
    public CaptchaExpireException(){
        super("Captcha Expire", HttpStatus.UNAUTHORIZED.value());
    }
}
