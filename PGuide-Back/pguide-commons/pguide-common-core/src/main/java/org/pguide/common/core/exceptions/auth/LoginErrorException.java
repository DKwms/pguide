package org.pguide.common.core.exceptions.auth;

import org.pguide.common.core.exceptions.AuthBaseException;
import org.pguide.common.core.constant.HttpStatus;

/**
 * @author DKwms
 * @Date 2023/9/19 21:58
 * @description
 */
public class LoginErrorException extends AuthBaseException {
    public LoginErrorException(){
        super("Password or Account Error", HttpStatus.UNAUTHORIZED.value());
    }
}
