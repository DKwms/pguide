package org.pguide.entity.index.info.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName index_partbox_type
 */
@TableName(value ="index_partbox_type")
@Data
public class IndexPartboxType implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer partboxId;

    /**
     * 
     */
    private String partboxType;

    /**
     * 
     */
    private String partboxState;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 1删除，0保留
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}