package com.pguide.project.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 project_log_detail
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public class ProjectLogDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志id */
    private Long logId;

    /** 日志id与top表关联 */
    @Excel(name = "日志id与top表关联")
    private Long logTypeId;

    /** 日志类型 0 日志抬头 1 本次更新 2 存在问题 3 未来规划 4*/
    @Excel(name = "日志类型 0日志抬头 1本次更新 2存在问题 3未来规划")
    private Long logDetailType;

    /** 日志信息 */
    @Excel(name = "日志信息")
    private String logInfo;

    /** 日志记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日志记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date logTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    public void setLogId(Long logId) 
    {
        this.logId = logId;
    }

    public Long getLogId() 
    {
        return logId;
    }
    public void setLogTypeId(Long logTypeId) 
    {
        this.logTypeId = logTypeId;
    }

    public Long getLogTypeId() 
    {
        return logTypeId;
    }
    public void setLogDetailType(Long logDetailType) 
    {
        this.logDetailType = logDetailType;
    }

    public Long getLogDetailType() 
    {
        return logDetailType;
    }
    public void setLogInfo(String logInfo) 
    {
        this.logInfo = logInfo;
    }

    public String getLogInfo() 
    {
        return logInfo;
    }
    public void setLogTime(Date logTime) 
    {
        this.logTime = logTime;
    }

    public Date getLogTime() 
    {
        return logTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("logTypeId", getLogTypeId())
            .append("logDetailType", getLogDetailType())
            .append("logInfo", getLogInfo())
            .append("logTime", getLogTime())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .toString();
    }
}
