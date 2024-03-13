package org.pguide.project.match.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName mms_project_detail_info
 */
@TableName(value ="mms_project_detail_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MmsProjectDetailInfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer projectId;

    /**
     * 项目简介(创建项目时录入)
     */
    private String projectIntroduction;

    /**
     * 项目详情介绍
     */
    private String projectDetails;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}