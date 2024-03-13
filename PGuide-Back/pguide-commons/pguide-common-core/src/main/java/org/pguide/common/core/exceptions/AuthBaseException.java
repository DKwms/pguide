package org.pguide.common.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2023/9/19 20:56
 * @description 鉴权异常
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthBaseException extends RuntimeException{
    private Integer code;
    private String msg;
    private String detail;

    public AuthBaseException(String msg,Integer code){
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String getMessage(){
        return this.msg;
    }

}
