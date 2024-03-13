package org.pguide.project.match.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName mms_need_recruit_info
 */
@TableName(value ="mms_need_recruit_info")
@Data
public class MmsNeedRecruitInfo implements Serializable {
    /**
     * id
     */
    @TableId
    private Integer recruitId;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 招募title
     */
    private String recruitName;

    /**
     * 需求类型，关联需求表及需求类型
     */
    private Integer needTypeId;

    /**
     * 开始时间
     */
    private LocalDateTime recruitStartTime;

    /**
     * 截止时间
     */
    private LocalDateTime recruitEndTime;

    /**
     * 发布人id
     */
    private String userId;

    /**
     * 奖励数,关联金币系统
     */
    private String recruitRw;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 0存在1删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}