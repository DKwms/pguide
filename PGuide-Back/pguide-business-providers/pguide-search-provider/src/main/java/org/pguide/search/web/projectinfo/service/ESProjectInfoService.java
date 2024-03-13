package org.pguide.search.web.projectinfo.service;

import org.pguide.api.search.domain.dto.ProjectInfo;
import org.pguide.common.core.result.JsonResult;

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
    JsonResult<Void> addObj(ProjectInfo projectInfo, int projectId);

    /**
     * GET<br>
     * 查询数据 by searchInfo，
     * 一般用于测试
     * 返回10条数据最多
     */
    JsonResult<List<ProjectInfo>> getAimObj(String searchInfo);

    /**
     * GET<br>
     * 查询数据，实现分页
     * 用于主页检索
     */
    JsonResult<List<ProjectInfo>> getAimObjPage(String searchInfo,int from,int size);
}
