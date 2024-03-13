package org.pguide.cms.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学科字典对象 cms_subject_dict
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public class CmsSubjectDict extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学科id */
    private Long subjectId;

    /** 学科名 */
    @Excel(name = "学科名")
    private String subjectName;

    /** 可见等级 */
    @Excel(name = "可见等级")
    private String subjectLevel;

    /** 父级id */
    @Excel(name = "父级id")
    private Long parentId;

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

    public void setSubjectId(Long subjectId) 
    {
        this.subjectId = subjectId;
    }

    public Long getSubjectId() 
    {
        return subjectId;
    }
    public void setSubjectName(String subjectName) 
    {
        this.subjectName = subjectName;
    }

    public String getSubjectName() 
    {
        return subjectName;
    }
    public void setSubjectLevel(String subjectLevel) 
    {
        this.subjectLevel = subjectLevel;
    }

    public String getSubjectLevel() 
    {
        return subjectLevel;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
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
            .append("subjectId", getSubjectId())
            .append("subjectName", getSubjectName())
            .append("subjectLevel", getSubjectLevel())
            .append("parentId", getParentId())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
