package org.pguide.auth.manage.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2024/1/5 19:12
 * @description
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeUserVo {

    /**
     * 系统名称
     */
    String sysName;

    /**
     * 用户名称，用;（半角）来隔开<br/>
     * 对应不同系统的登录标识符
     */
    String sysUser;
}
