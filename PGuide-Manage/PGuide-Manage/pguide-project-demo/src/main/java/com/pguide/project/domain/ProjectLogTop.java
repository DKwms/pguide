package com.pguide.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 project_log_top
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public class ProjectLogTop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目日志ID */
    private Long logTypeId;

    /** 日志类型(大标题) */
    @Excel(name = "日志类型(大标题)")
    private String logType;

    /** 日志作者 */
    @Excel(name = "日志作者")
    private String logAuthor;

    public void setLogTypeId(Long logTypeId) 
    {
        this.logTypeId = logTypeId;
    }

    public Long getLogTypeId() 
    {
        return logTypeId;
    }
    public void setLogType(String logType) 
    {
        this.logType = logType;
    }

    public String getLogType() 
    {
        return logType;
    }
    public void setLogAuthor(String logAuthor) 
    {
        this.logAuthor = logAuthor;
    }

    public String getLogAuthor() 
    {
        return logAuthor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logTypeId", getLogTypeId())
            .append("logType", getLogType())
            .append("logAuthor", getLogAuthor())
            .toString();
    }
}
