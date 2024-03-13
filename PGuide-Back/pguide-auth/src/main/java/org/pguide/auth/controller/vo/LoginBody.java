package org.pguide.auth.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2023/9/18 22:44
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginBody {

    String account;
    String password;
    // 系统类型
    String sysType;
    //用户类型(前端选项控制)
    String userType;
    String code;
    String uuid;
    String redirectUrl;

    /**
     * 冗余字段，作为后续策略模式为vo负载数据
     */
    // 用户id
    Integer userId;
    // 工号
    String workId;
    // 用户名
    String userName;
    // school
    String workSpace;
    // academy
    String workDept;
    // 班级
    String workClass;

    String studentYear;
}
