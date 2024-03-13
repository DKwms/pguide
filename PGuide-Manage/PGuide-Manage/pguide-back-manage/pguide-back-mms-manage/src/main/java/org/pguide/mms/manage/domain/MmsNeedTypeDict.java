package org.pguide.mms.manage.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 需求类型字典表对象 mms_need_type_dict
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public class MmsNeedTypeDict extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 需求类型 */
    @TableId
    private Long needTypeId;

    /** 需求类型名 */
    @Excel(name = "需求类型名")
    private String needTypeName;

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
    private Long deleted;

    public void setNeedTypeId(Long needTypeId) 
    {
        this.needTypeId = needTypeId;
    }

    public Long getNeedTypeId() 
    {
        return needTypeId;
    }
    public void setNeedTypeName(String needTypeName) 
    {
        this.needTypeName = needTypeName;
    }

    public String getNeedTypeName() 
    {
        return needTypeName;
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
            .append("needTypeId", getNeedTypeId())
            .append("needTypeName", getNeedTypeName())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
