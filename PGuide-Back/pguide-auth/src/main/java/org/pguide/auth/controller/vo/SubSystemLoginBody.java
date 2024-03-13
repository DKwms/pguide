package org.pguide.auth.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author DKwms
 * @Date 2023/10/2 14:05
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubSystemLoginBody extends LoginBody{
    String account;
    String password;
    String code;
    String uuid;
    String redirectUrl;
    // 子系统tokenCode
    String tokenCode;
}
