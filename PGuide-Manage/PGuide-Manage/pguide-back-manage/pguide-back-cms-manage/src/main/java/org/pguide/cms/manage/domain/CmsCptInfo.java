package org.pguide.cms.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 比赛信息对象 cms_cpt_info
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public class CmsCptInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 竞赛id */
    private Long cptId;

    /** 竞赛名称 */
    @Excel(name = "竞赛名称")
    private String cptName;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cptStartTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cptEndTime;

    /** 地区 */
    @Excel(name = "地区")
    private String cptArea;

    /** 学科 */
    @Excel(name = "学科")
    private String cptSubject;

    /** 组织 */
    @Excel(name = "组织")
    private String orgId;

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

    public void setCptId(Long cptId) 
    {
        this.cptId = cptId;
    }

    public Long getCptId() 
    {
        return cptId;
    }
    public void setCptName(String cptName) 
    {
        this.cptName = cptName;
    }

    public String getCptName() 
    {
        return cptName;
    }
    public void setCptStartTime(Date cptStartTime) 
    {
        this.cptStartTime = cptStartTime;
    }

    public Date getCptStartTime() 
    {
        return cptStartTime;
    }
    public void setCptEndTime(Date cptEndTime) 
    {
        this.cptEndTime = cptEndTime;
    }

    public Date getCptEndTime() 
    {
        return cptEndTime;
    }
    public void setCptArea(String cptArea) 
    {
        this.cptArea = cptArea;
    }

    public String getCptArea() 
    {
        return cptArea;
    }
    public void setCptSubject(String cptSubject) 
    {
        this.cptSubject = cptSubject;
    }

    public String getCptSubject() 
    {
        return cptSubject;
    }
    public void setOrgId(String orgId) 
    {
        this.orgId = orgId;
    }

    public String getOrgId() 
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
            .append("cptId", getCptId())
            .append("cptName", getCptName())
            .append("cptStartTime", getCptStartTime())
            .append("cptEndTime", getCptEndTime())
            .append("cptArea", getCptArea())
            .append("cptSubject", getCptSubject())
            .append("orgId", getOrgId())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
