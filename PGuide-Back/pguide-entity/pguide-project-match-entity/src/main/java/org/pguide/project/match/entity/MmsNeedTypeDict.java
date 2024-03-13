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
 * @TableName mms_need_type_dict
 */
@TableName(value ="mms_need_type_dict")
@Data
public class MmsNeedTypeDict implements Serializable {
    /**
     * 需求类型
     */
    @TableId
    private Integer needTypeId;

    /**
     * 需求类型名
     */
    private String needTypeName;

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