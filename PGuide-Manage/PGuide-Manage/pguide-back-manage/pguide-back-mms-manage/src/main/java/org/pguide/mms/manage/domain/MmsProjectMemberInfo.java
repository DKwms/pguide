package org.pguide.mms.manage.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目成员信息表对象 mms_project_member_info
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public class MmsProjectMemberInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    @TableId
    private Long projectId;

    /** 成员id */
    @Excel(name = "成员id")
    private Long memberId;

    /** 成员类型id */
    @Excel(name = "成员类型id")
    private Long memberTypeId;

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

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setMemberTypeId(Long memberTypeId) 
    {
        this.memberTypeId = memberTypeId;
    }

    public Long getMemberTypeId() 
    {
        return memberTypeId;
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
            .append("projectId", getProjectId())
            .append("memberId", getMemberId())
            .append("memberTypeId", getMemberTypeId())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
