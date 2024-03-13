package org.pguide.mms.manage.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目信息主表对象 mms_project_info
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public class MmsProjectInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    @TableId
    private Long projectId;

    /** 名称 */
    @Excel(name = "名称")
    private String projectName;

    /** 学科 */
    @Excel(name = "学科")
    private String projectSubjectType;

    /** 开放级别 */
    @Excel(name = "开放级别")
    private String projectOpenLevel;

    @Excel(name="审核状态")
    private String projectStatusId;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long deleted;

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectSubjectType(String projectSubjectType) 
    {
        this.projectSubjectType = projectSubjectType;
    }

    public String getProjectSubjectType() 
    {
        return projectSubjectType;
    }
    public void setProjectOpenLevel(String projectOpenLevel) 
    {
        this.projectOpenLevel = projectOpenLevel;
    }

    public String getProjectOpenLevel() 
    {
        return projectOpenLevel;
    }
    public void setCreated(Date created) 
    {
        this.created = created;
    }

    public Date getCreated() 
    {
        return created;
    }
    public void setUpdated(Date updated) 
    {
        this.updated = updated;
    }

    public Date getUpdated() 
    {
        return updated;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("projectSubjectType", getProjectSubjectType())
            .append("projectOpenLevel", getProjectOpenLevel())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
