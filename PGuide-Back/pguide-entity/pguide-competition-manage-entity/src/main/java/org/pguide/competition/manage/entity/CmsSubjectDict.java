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
 * @TableName cms_subject_dict
 */
@TableName(value ="cms_subject_dict")
@Data
public class CmsSubjectDict implements Serializable {
    /**
     * 学科id
     */
    @TableId(type = IdType.AUTO)
    private Integer subjectId;

    /**
     * 学科名
     */
    private String subjectName;

    /**
     * 学科等级
     */
    private String subjectLevel;

    /**
     * 学科父级id subject_id
     */
    private Integer parentId;

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