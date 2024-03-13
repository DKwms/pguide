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
 * @TableName mms_project_competition_data
 */
@TableName(value ="mms_project_competition_data")
@Data
public class MmsProjectCompetitionData implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer projectId;

    /**
     * 竞赛id,关联cms竞赛字典表
     */
    private Integer competitionId;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}