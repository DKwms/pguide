package org.pguide.cms.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 组织字典对象 cms_org_dict
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public class CmsOrgDict extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 组织id */
    private Long orgId;

    /** 组织名 */
    @Excel(name = "组织名")
    private String orgName;

    /** 成立时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orgStartTime;

    /** 上属 组织 */
    @Excel(name = "上属 组织")
    private Long orgParentId;

    /** 所属地区 */
    @Excel(name = "所属地区")
    private String orgArea;

    /** 收录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer deleted;

    public void setOrgId(Long orgId) 
    {
        this.orgId = orgId;
    }

    public Long getOrgId() 
    {
        return orgId;
    }
    public void setOrgName(String orgName) 
    {
        this.orgName = orgName;
    }

    public String getOrgName() 
    {
        return orgName;
    }
    public void setOrgStartTime(Date orgStartTime) 
    {
        this.orgStartTime = orgStartTime;
    }

    public Date getOrgStartTime() 
    {
        return orgStartTime;
    }
    public void setOrgParentId(Long orgParentId) 
    {
        this.orgParentId = orgParentId;
    }

    public Long getOrgParentId() 
    {
        return orgParentId;
    }
    public void setOrgArea(String orgArea) 
    {
        this.orgArea = orgArea;
    }

    public String getOrgArea() 
    {
        return orgArea;
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
            .append("orgId", getOrgId())
            .append("orgName", getOrgName())
            .append("orgStartTime", getOrgStartTime())
            .append("orgParentId", getOrgParentId())
            .append("orgArea", getOrgArea())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
