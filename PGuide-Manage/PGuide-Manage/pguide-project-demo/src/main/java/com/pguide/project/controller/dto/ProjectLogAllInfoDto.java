package com.pguide.project.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO 返回日志的全部信息
 * @date 2023/9/27 13:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectLogAllInfoDto {
    /**
     * 每个日志卡片的id
     */
    @Getter
    private Long logId;
    /**
     * 用于区分日志的id
     */
    private Long logTypeId;
    /**
     * 用于区分卡片的类型(小标题)(数据库中的log_detail_type)
     * 0 日志抬头 1本次更新 2存在问题 3未来规划
     */
    private Long logDetailType;
    /**
     * 日志信息(数据库中的log_info)
     * 拼接成    - xxx</br> - xxx形式
     */
    private String logInfo;
    /**
     * 日志记录时间
     */
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date logTime;
    /**
     * 日志类型(大标题)
     */
    private String logType;
    /**
     * 日志作者
     */
    private String logAuthor;

    public String getLogInfo(){
        this.logInfo = "- ".concat(this.logInfo).replace("|", "</br>- ");
        return logInfo;
    }

}
