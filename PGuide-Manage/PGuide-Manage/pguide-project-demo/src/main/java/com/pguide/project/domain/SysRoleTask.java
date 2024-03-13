package com.pguide.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName sys_role_task
 */
@TableName(value ="sys_role_task")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleTask implements Serializable {
    /**
     * 角色id
     */
    @TableId
    private String roleId;

    /**
     * 任务id
     */
    private Integer taskId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}