package org.pguide.mms.manage.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目从属信息表对象 mms_project_belong_info
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public class MmsProjectBelongInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 从属id */
    @TableId
    private Long belongId;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 学校id */
    @Excel(name = "学校id")
    private Long schoolId;

    /** 学院id */
    @Excel(name = "学院id")
    private Long academyId;

    /** 组织id */
    @Excel(name = "组织id")
    private Long orgId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer deleted;

    public void setBelongId(Long belongId) 
    {
        this.belongId = belongId;
    }

    public Long getBelongId() 
    {
        return belongId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setSchoolId(Long schoolId) 
    {
        this.schoolId = schoolId;
    }

    public Long getSchoolId() 
    {
        return schoolId;
    }
    public void setAcademyId(Long academyId) 
    {
        this.academyId = academyId;
    }

    public Long getAcademyId() 
    {
        return academyId;
    }
    public void setOrgId(Long orgId) 
    {
        this.orgId = orgId;
    }

    public Long getOrgId() 
    {
        return orgId;
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
    public void setDeleted(Integer deleted) 
    {
        this.deleted = deleted;
    }

    public Integer getDeleted() 
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("belongId", getBelongId())
            .append("projectId", getProjectId())
            .append("schoolId", getSchoolId())
            .append("academyId", getAcademyId())
            .append("orgId", getOrgId())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
