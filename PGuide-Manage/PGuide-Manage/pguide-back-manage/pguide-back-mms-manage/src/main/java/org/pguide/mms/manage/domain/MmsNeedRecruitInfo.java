package org.pguide.mms.manage.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目需求招募信息对象 mms_need_recruit_info
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public class MmsNeedRecruitInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId
    private Long recruitId;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 招募标题 */
    @Excel(name = "招募标题")
    private String recruitName;

    /** 需求类型 */
    @Excel(name = "需求类型")
    private Long needTypeId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recruitStartTime;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recruitEndTime;

    /** 发布人id */
    @Excel(name = "发布人id")
    private String userId;

    /** 奖励数 */
    @Excel(name = "奖励数")
    private String recruitRw;

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

    public void setRecruitId(Long recruitId) 
    {
        this.recruitId = recruitId;
    }

    public Long getRecruitId() 
    {
        return recruitId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setRecruitName(String recruitName) 
    {
        this.recruitName = recruitName;
    }

    public String getRecruitName() 
    {
        return recruitName;
    }
    public void setNeedTypeId(Long needTypeId) 
    {
        this.needTypeId = needTypeId;
    }

    public Long getNeedTypeId() 
    {
        return needTypeId;
    }
    public void setRecruitStartTime(Date recruitStartTime) 
    {
        this.recruitStartTime = recruitStartTime;
    }

    public Date getRecruitStartTime() 
    {
        return recruitStartTime;
    }
    public void setRecruitEndTime(Date recruitEndTime) 
    {
        this.recruitEndTime = recruitEndTime;
    }

    public Date getRecruitEndTime() 
    {
        return recruitEndTime;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setRecruitRw(String recruitRw) 
    {
        this.recruitRw = recruitRw;
    }

    public String getRecruitRw() 
    {
        return recruitRw;
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
            .append("recruitId", getRecruitId())
            .append("projectId", getProjectId())
            .append("recruitName", getRecruitName())
            .append("needTypeId", getNeedTypeId())
            .append("recruitStartTime", getRecruitStartTime())
            .append("recruitEndTime", getRecruitEndTime())
            .append("userId", getUserId())
            .append("recruitRw", getRecruitRw())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
