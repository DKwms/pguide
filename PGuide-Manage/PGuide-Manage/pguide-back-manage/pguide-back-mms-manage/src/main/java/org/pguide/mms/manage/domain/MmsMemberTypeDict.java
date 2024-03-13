package org.pguide.mms.manage.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成员属性字典表对象 mms_member_type_dict
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public class MmsMemberTypeDict extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId
    private Long memberTypeId;

    /** 成员属性名 */
    @Excel(name = "成员属性名")
    private String memberTypeName;

    /** 成员属性关键字 */
    @Excel(name = "成员属性关键字")
    private String memberTypeKey;

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
    private Integer deleted;

    public void setMemberTypeId(Long memberTypeId) 
    {
        this.memberTypeId = memberTypeId;
    }

    public Long getMemberTypeId() 
    {
        return memberTypeId;
    }
    public void setMemberTypeName(String memberTypeName) 
    {
        this.memberTypeName = memberTypeName;
    }

    public String getMemberTypeName() 
    {
        return memberTypeName;
    }
    public void setMemberTypeKey(String memberTypeKey) 
    {
        this.memberTypeKey = memberTypeKey;
    }

    public String getMemberTypeKey() 
    {
        return memberTypeKey;
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
            .append("memberTypeId", getMemberTypeId())
            .append("memberTypeName", getMemberTypeName())
            .append("memberTypeKey", getMemberTypeKey())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
