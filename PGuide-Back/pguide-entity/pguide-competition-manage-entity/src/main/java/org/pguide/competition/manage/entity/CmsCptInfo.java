package org.pguide.competition.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName cms_cpt_info
 */
@TableName(value ="cms_cpt_info")
@Data
public class CmsCptInfo implements Serializable {
    /**
     * 竞赛id
     */
    @TableId
    private Integer cptId;

    /**
     * 竞赛名称
     */
    private String cptName;

    /**
     * 竞赛开始时间
     */
    private LocalDateTime cptStartTime;

    /**
     * 竞赛结束时间
     */
    private LocalDateTime cptEndTime;

    /**
     * 竞赛地区
     */
    private String cptArea;

    /**
     * 竞赛学科
     */
    private String cptSubject;

    /**
     * 竞赛组织
     */
    private String orgId;

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