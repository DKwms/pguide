package org.pguide.user.entity.vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/20 16:18
 * @description
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo implements Serializable {

    private String userName;
    private String userSchool;
    private String userAccount;
    private String userAcademy;
    private String userType;
    private Integer userId;
    private String workId;
    // 学生年级
    private String studentYear;
    private List<UserGroup> userGroup;

}

