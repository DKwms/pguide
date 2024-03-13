package com.pguide.project.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pguide.project.domain.ProjectTaskTag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * @Author DKwms
 * @Date 2023 11 2023/11/9 11 22
 * 每张卡片对应实体<br/>
 * tags数组待优化
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectTaskDto {

    /** id */
    private Long taskId;

    /** 任务名 */
    private String taskName;

    /** 任务详情 */
    private String taskDetail;

    /** 任务起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Timestamp taskStartTime;

    /** 任务截至时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Timestamp taskEndTime;

    /** 任务显示状态 0关闭 1显示 */
    private Long taskShow;

    /** 任务状态 0未开始 1进行中 2已完成 3暂停 4废除 */
    private Long taskStateType;

    /** 冗余字段，对应用户表中用户名 */
    private String userName;

    /** 完成奖励金币数 */
    private Long reward;

    ArrayList<ProjectTaskTag> tags;
}
