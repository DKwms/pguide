package org.pguide.entity.index.info.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;


/**
 * 
 * @TableName index_partbox_info
 */
@TableName(value ="index_partbox_info")
@Data
public class IndexPartboxInfo implements Serializable {


    /**
     * 
     */
    @TableId
    private Integer partboxId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}