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
 * @TableName index_carousel_img
 */
@TableName(value ="index_carousel_img")
@Data
public class IndexCarouselImg implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer carouselImgId;

    /**
     * 
     */
    private String carouselImgType;

    /**
     * 
     */
    private String carouselImgUrl;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    /**
     * 1删除，0未删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}