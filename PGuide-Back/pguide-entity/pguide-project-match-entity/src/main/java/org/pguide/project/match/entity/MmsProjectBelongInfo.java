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
 * @TableName mms_project_belong_info
 */
@TableName(value ="mms_project_belong_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MmsProjectBelongInfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer belongId;

    /**
     * 
     */
    private Integer projectId;

    /**
     * 学校id
     */
    private Integer schoolId;

    /**
     * 学院id
     */
    private Integer academyId;

    /**
     * 组织id，后期添加
     */
    private Integer orgId;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 0存在1删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}