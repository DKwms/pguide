package org.pguide.project.match.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author DKwms
 * @Date 2024 02 2024/2/3 16 01
 * 项目详情创建信息，前端页面对应步骤二，步骤一只发起项目名重复检查
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailCreateVo {

    // 项目类型
    String projectName;

    // 项目类型
    String projectTypeId;

    // 项目类型
    String ProjectStatusId;

}
