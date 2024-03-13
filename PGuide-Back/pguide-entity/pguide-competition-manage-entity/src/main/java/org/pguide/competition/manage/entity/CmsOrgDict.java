package org.pguide.competition.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName cms_org_dict
 */
@TableName(value ="cms_org_dict")
@Data
public class CmsOrgDict implements Serializable {
    /**
     * 组织id
     */
    @TableId
    private Integer orgId;

    /**
     * 组织名
     */
    private String orgName;

    /**
     * 组织成立时间
     */
    private LocalDateTime orgStartTime;

    /**
     * 组织上属 org_id
     */
    private LocalDateTime orgParentId;

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