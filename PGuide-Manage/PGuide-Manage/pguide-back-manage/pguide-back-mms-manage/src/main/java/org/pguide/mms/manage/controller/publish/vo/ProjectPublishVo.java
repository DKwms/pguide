package org.pguide.mms.manage.controller.publish.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author DKwms
 * @Date 2024/2/18 16:53
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectPublishVo {

    String projectName;
    // 学校信息由字典表提供，这里只传id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Integer projectSchoolId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Integer projectAcademyId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Integer projectClassId;

    String projectSchool;
    String projectAcademy;
    String projectClass;

    String projectType;
    // 记录项目的信息
    String projectInfo;
    String projectAdmin;
    String projectOpenLevel;
    Integer projectStatus;



    // 检索字段
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    LocalDateTime startTime;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    LocalDateTime endTime;

}
