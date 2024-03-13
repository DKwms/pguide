package org.pguide.mms.manage.controller.publish.es.service;


import com.ruoyi.common.core.domain.AjaxResult;
import org.pguide.mms.manage.controller.publish.es.domain.dto.ProjectInfo;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/23 10:44
 * @description
 */


public interface ESProjectInfoService {

    /**
     * POST<br>
     * 新增数据
     */
    AjaxResult addObj(ProjectInfo projectInfo, int projectId);

    /**
     * GET<br>
     * 查询数据 by searchInfo，
     * 一般用于测试
     * 返回10条数据最多
     */
    AjaxResult getAimObj(String searchInfo);

    /**
     * GET<br>
     * 查询数据，实现分页
     * 用于主页检索
     */
    AjaxResult getAimObjPage(String searchInfo,int from,int size);
}
