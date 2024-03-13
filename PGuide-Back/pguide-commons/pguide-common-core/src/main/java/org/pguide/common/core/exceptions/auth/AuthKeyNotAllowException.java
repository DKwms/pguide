package org.pguide.common.core.exceptions.auth;

import org.pguide.common.core.constant.HttpStatus;
import org.pguide.common.core.exceptions.AuthBaseException;

/**
 * @author DKwms
 * @Date 2024/1/31 15:07
 * @description 权限关键字不匹配，无权限访问或是权限异常
 */
public class AuthKeyNotAllowException extends AuthBaseException {
    public AuthKeyNotAllowException(){
        super("AuthKeyNotAllow Error", HttpStatus.FORBIDDEN.value());
    }

}
