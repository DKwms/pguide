package org.pguide.studio.place.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName studio_place_time
 */
@TableName(value ="studio_place_time")
public class StudioPlaceTime implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private String placeDate;

    /**
     * 场地id
     */
    private Integer placeId;

    /**
     * 时间块编号
     */
    private String placeBlockId;

    /**
     * 时间块状态
     */
    private String placeBlockStatus;

    /**
     * 关联在线人表id
     */
    private Integer placePeopleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public String getPlaceDate() {
        return placeDate;
    }

    /**
     * 主键id
     */
    public void setPlaceDate(String placeDate) {
        this.placeDate = placeDate;
    }

    /**
     * 场地id
     */
    public Integer getPlaceId() {
        return placeId;
    }

    /**
     * 场地id
     */
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    /**
     * 时间块编号
     */
    public String getPlaceBlockId() {
        return placeBlockId;
    }

    /**
     * 时间块编号
     */
    public void setPlaceBlockId(String placeBlockId) {
        this.placeBlockId = placeBlockId;
    }

    /**
     * 时间块状态
     */
    public String getPlaceBlockStatus() {
        return placeBlockStatus;
    }

    /**
     * 时间块状态
     */
    public void setPlaceBlockStatus(String placeBlockStatus) {
        this.placeBlockStatus = placeBlockStatus;
    }

    /**
     * 关联在线人表id
     */
    public Integer getPlacePeopleId() {
        return placePeopleId;
    }

    /**
     * 关联在线人表id
     */
    public void setPlacePeopleId(Integer placePeopleId) {
        this.placePeopleId = placePeopleId;
    }
}