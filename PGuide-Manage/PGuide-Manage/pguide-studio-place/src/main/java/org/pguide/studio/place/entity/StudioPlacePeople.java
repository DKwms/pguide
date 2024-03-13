package org.pguide.studio.place.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName studio_place_people
 */
@TableName(value ="studio_place_people")
public class StudioPlacePeople implements Serializable {
    /**
     * 在线人id
     */
    @TableId
    private Integer placePeopleId;

    /**
     * 用户表关联id
     */
    private Integer userId;

    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 当前次留言
     */
    private String placePeopleMsg;

    /**
     * 用户当前状态(0离开|1在工作室|2暂时离开)
     */
    private Integer placePeopleStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 在线人id
     */
    public Integer getPlacePeopleId() {
        return placePeopleId;
    }

    /**
     * 在线人id
     */
    public void setPlacePeopleId(Integer placePeopleId) {
        this.placePeopleId = placePeopleId;
    }

    /**
     * 用户表关联id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户表关联id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户头像
     */
    public String getUserImg() {
        return userImg;
    }

    /**
     * 用户头像
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    /**
     * 当前次留言
     */
    public String getPlacePeopleMsg() {
        return placePeopleMsg;
    }

    /**
     * 当前次留言
     */
    public void setPlacePeopleMsg(String placePeopleMsg) {
        this.placePeopleMsg = placePeopleMsg;
    }

    /**
     * 用户当前状态(0离开|1在工作室|2暂时离开)
     */
    public Integer getPlacePeopleStatus() {
        return placePeopleStatus;
    }

    /**
     * 用户当前状态(0离开|1在工作室|2暂时离开)
     */
    public void setPlacePeopleStatus(Integer placePeopleStatus) {
        this.placePeopleStatus = placePeopleStatus;
    }
}