package org.pguide.mms.manage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName mms_project_type_info
 */
@TableName(value ="mms_project_type_info")
@Data
public class MmsProjectTypeInfo implements Serializable {
    /**
     * 项目类型id
     */
    @TableId
    private Integer projectTypeId;

    /**
     * 项目类型名
     */
    private String projectTypeName;

    /**
     * 项目人员上限
     */
    private String projectTypePeopleCount;

    /**
     * 项目类型级别，自由项目和非自由项目，free,unfree
     */
    private String projectTypeLevel;

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