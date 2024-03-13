package org.pguide.common.core.exceptions.auth;

import org.pguide.common.core.exceptions.AuthBaseException;
import org.pguide.common.core.constant.HttpStatus;

/**
 * @author DKwms
 * @Date 2023/10/2 14:18
 * @description
 */
public class LoginInfoNotAllowException extends AuthBaseException {
    public LoginInfoNotAllowException(){
        super("loginInfoError", HttpStatus.BAD_REQUEST.value());
    }
}
