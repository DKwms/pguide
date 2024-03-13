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
 * @TableName mms_member_type_dict
 */
@TableName(value ="mms_member_type_dict")
@Data
public class MmsMemberTypeDict implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer memberTypeId;

    /**
     * 用户属性名
     */
    private String memberTypeName;

    /**
     * 用户属性关键字
     */
    private String memberTypeKey;

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