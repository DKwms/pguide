package org.pguide.project.match.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName mms_project_info
 */
@TableName(value ="mms_project_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MmsProjectInfo implements Serializable {
    /**
     * 项目id，uuid
     */
    @TableId
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型id
     */
    private Integer projectTypeId;

    /**
     * 项目学科
     */
    private String projectSubjectType;

    /**
     * 项目开放级别，”学校id:学院id:项目id“,*通配
     */
    private String projectOpenLevel;

    /**
     * 项目状态，包括未通过审核和正常项目状态
     */
    private Integer projectStatusId;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 0存在，1删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}