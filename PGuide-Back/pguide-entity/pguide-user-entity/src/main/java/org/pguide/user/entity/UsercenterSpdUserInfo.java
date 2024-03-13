package org.pguide.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName usercenter_spd_user_info
 */
@TableName(value ="usercenter_spd_user_info")
@Data
public class UsercenterSpdUserInfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}