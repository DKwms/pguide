package org.pguide.project.match.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2024/2/3 13:10
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectCreatedVo {

    String name;
    // 项目类型，free | unfree
    String typeLevel;
    // 项目比赛方向
    String type;

    String school;

    String academy;
    // 项目创建详情（项目简介）
    String detail;
    // 项目学科
    String subject;
    // 开放等级
    String openLevel;
}
