package org.pguide.user.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName third_party_login
 */
@TableName(value ="third_party_login")
@Data
public class ThirdPartyLogin implements Serializable {
    /**
     * 第三方登录id
     */
    @TableId
    private Integer thirdPartyId;

    /**
     * 第三方登录名称
     */
    private String thirdPartyName;

    /**
     * 第三方登录图片URL
     */
    private String thirdPartyImg;

    /**
     * 第三方登录跳转地址
     */
    private String thirdPartyLinkurl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}