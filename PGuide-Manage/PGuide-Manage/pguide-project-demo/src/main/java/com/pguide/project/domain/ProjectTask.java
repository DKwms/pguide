package com.pguide.project.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 project_task
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public class ProjectTask {
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId("task_id")
    private Long taskId;

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

    /** 冗余字段，对应用户表中用户名 */
    @Excel(name = "冗余字段，对应用户表中用户名")
    private String userName;

    /** 完成奖励金币数 */
    @Excel(name = "完成奖励金币数")
    private Long reward;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 逻辑删除，1表示删除，0没删 */
    @Excel(name = "逻辑删除，1表示删除，0没删")
    private Long deleted;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setTaskDetail(String taskDetail) 
    {
        this.taskDetail = taskDetail;
    }

    public String getTaskDetail() 
    {
        return taskDetail;
    }
    public void setTaskStartTime(Date taskStartTime) 
    {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskStartTime() 
    {
        return taskStartTime;
    }
    public void setTaskEndTime(Date taskEndTime) 
    {
        this.taskEndTime = taskEndTime;
    }

    public Date getTaskEndTime() 
    {
        return taskEndTime;
    }
    public void setTaskShow(Long taskShow) 
    {
        this.taskShow = taskShow;
    }

    public Long getTaskShow() 
    {
        return taskShow;
    }
    public void setTaskStateType(Long taskStateType) 
    {
        this.taskStateType = taskStateType;
    }

    public Long getTaskStateType() 
    {
        return taskStateType;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setReward(Long reward) 
    {
        this.reward = reward;
    }

    public Long getReward() 
    {
        return reward;
    }
    public void setCreated(Date created) 
    {
        this.created = created;
    }

    public Date getCreated() 
    {
        return created;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }
    public void setUpdated(Date updated) 
    {
        this.updated = updated;
    }

    public Date getUpdated() 
    {
        return updated;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("taskName", getTaskName())
            .append("taskDetail", getTaskDetail())
            .append("taskStartTime", getTaskStartTime())
            .append("taskEndTime", getTaskEndTime())
            .append("taskShow", getTaskShow())
            .append("taskStateType", getTaskStateType())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("reward", getReward())
            .append("created", getCreated())
            .append("deleted", getDeleted())
            .append("updated", getUpdated())
            .toString();
    }
}
