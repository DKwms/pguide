package com.pguide.project.controller.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author DKwms
 * @Date 2023/11/15 11:35
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectTaskAddVo {

    /**
     * role
     * sys_role_task, 角色表数据
     */
    @Excel(name="权限编号")
    private Long optionResult;

    // 用于获取自增id
    private int id;

    /**
     * base ProjectTaskAndVo
     * project_task 表数据
     */

    /** 任务名 */
    @Excel(name = "任务名")
    @TableField("task_name")
    private String taskName;

    /** 任务详情 */
    @Excel(name = "任务详情")
    private String taskDetail;

    /** 任务起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date taskStartTime;

    /** 任务截至时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务截至时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date taskEndTime;

    /** 任务显示状态 0关闭 1显示 */
    @Excel(name = "任务显示状态 0关闭 1显示")
    private Long taskShow;

    /** 任务状态 0未开始 1进行中 2已完成 3暂停 4废除 */
    @Excel(name = "任务状态 0未开始 1进行中 2已完成 3暂停 4废除")
    private Long taskStateType;

    /** 发布者id */
    @Excel(name = "发布者id")
    private String userId;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;


    /** 冗余字段，对应用户表中用户名 */
    @Excel(name = "冗余字段，对应用户表中用户名")
    private String userName;

    /** 完成奖励金币数 */
    @Excel(name = "完成奖励金币数")
    private Long reward;


}
