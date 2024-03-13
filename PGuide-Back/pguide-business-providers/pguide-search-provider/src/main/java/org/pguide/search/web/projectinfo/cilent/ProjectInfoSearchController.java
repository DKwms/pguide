package org.pguide.search.web.projectinfo.cilent;

import org.pguide.api.search.domain.dto.ProjectInfo;
import org.pguide.api.search.feign.ProjectInfoSearchClient;
import org.pguide.common.core.result.JsonResult;
import org.pguide.search.web.projectinfo.service.impl.ESProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DKwms
 * @Date 2024/1/17 20:17
 * @description 项目信息搜索
 *
 * 所有搜索结束后都需要跳转详情页
 */
@RestController
public class ProjectInfoSearchController implements ProjectInfoSearchClient {

    @Autowired
    ESProjectInfoServiceImpl service;


    /**
     * 新增文档
     */
    @Override
    public JsonResult<Void> addNewProjectInfo(ProjectInfo projectInfo, int projectId) {
        return service.addObj(projectInfo, projectId);
    }

}


