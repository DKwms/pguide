package com.pguide.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 project_task_tag
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public class ProjectTaskTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Id */

    private Long tagsId;

    /** tags名 */
    @Excel(name = "tags名")
    private String tagsName;

    /** tags类型，null,success,warning,danger */
    @Excel(name = "tags类型，null,success,warning,danger")
    private String tagsType;

    /** 所属task */
    @Excel(name = "所属task")
    private Long taskId;

    public void setTagsId(Long tagsId) 
    {
        this.tagsId = tagsId;
    }

    public Long getTagsId() 
    {
        return tagsId;
    }
    public void setTagsName(String tagsName) 
    {
        this.tagsName = tagsName;
    }

    public String getTagsName() 
    {
        return tagsName;
    }
    public void setTagsType(String tagsType) 
    {
        this.tagsType = tagsType;
    }

    public String getTagsType() 
    {
        return tagsType;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tagsId", getTagsId())
            .append("tagsName", getTagsName())
            .append("tagsType", getTagsType())
            .append("taskId", getTaskId())
            .toString();
    }
}
