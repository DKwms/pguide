package org.pguide.common.core.exceptions.auth;

import org.pguide.common.core.exceptions.AuthBaseException;
import org.pguide.common.core.constant.HttpStatus;

/**
 * @author DKwms
 * @Date 2023/10/2 15:10
 * @description
 */
public class UserNotFoundException extends AuthBaseException {
    public UserNotFoundException(){
        super("user not found in user center!", HttpStatus.FORBIDDEN.value());
    }
}
