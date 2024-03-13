package org.pguide.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName sys_auth_info
 */
@TableName(value ="sys_auth_info")
@Data
public class SysAuthInfo implements Serializable {
    /**
     * 系统id
     */
    @TableId
    private Integer sysId;

    /**
     * 系统名称
     */
    private String sysName;

    /**
     * 系统类型,open开启登录鉴权，close关闭
     */
    private String sysType;

    /**
     * 半角;分割
     */
    private String sysUser;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 0删除，1未删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}