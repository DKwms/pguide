package com.pguide.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 project_task_receiver
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public class ProjectTaskReceiver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long taskId;

    /** $column.columnComment */
    private Long userId;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("userId", getUserId())
            .toString();
    }
}
