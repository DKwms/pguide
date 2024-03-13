package com.pguide.project.controller.vo;

import com.ruoyi.common.utils.StringUtils;
import io.jsonwebtoken.lang.Strings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/10/8 14:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectLogVo {
    /**
     * 作者姓名
     */
    private String logAuthor;
    /**
     * 大标题
     */
    private String logType;
    /**
     * 小标题
     */
    private Long logDetailType;
    /**
     * 页数
     */
    private Integer page;

}
