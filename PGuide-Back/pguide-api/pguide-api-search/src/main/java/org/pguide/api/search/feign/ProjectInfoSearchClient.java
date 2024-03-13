package org.pguide.api.search.feign;

import org.pguide.api.search.domain.dto.ProjectInfo;
import org.pguide.common.core.result.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author DKwms
 * @Date 2024/1/23 11:41
 * @description
 */

@FeignClient(value = "pguide-search", contextId = "pguideSearch")
public interface ProjectInfoSearchClient {

    /**
     * 新增文档
     *
     * @param projectInfo 项目信息
     * @param projectId   项目id
     * @return
     */
    @PostMapping("/api/search/add")
    JsonResult<Void> addNewProjectInfo(ProjectInfo projectInfo, int projectId);

}
