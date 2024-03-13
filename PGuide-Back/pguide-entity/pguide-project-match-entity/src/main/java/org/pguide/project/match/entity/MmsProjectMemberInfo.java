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
 * @TableName mms_project_member_info
 */
@TableName(value ="mms_project_member_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MmsProjectMemberInfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer projectId;

    /**
     * 关联用户中心 user_id
     */
    private Integer memberId;

    /**
     * 成员类型
     */
    private Integer memberTypeId;

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