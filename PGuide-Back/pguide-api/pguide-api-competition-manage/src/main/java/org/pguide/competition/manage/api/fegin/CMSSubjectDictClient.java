package org.pguide.competition.manage.api.fegin;

import org.pguide.common.core.result.JsonResult;
import org.pguide.competition.manage.entity.CmsSubjectDict;
import org.pguide.competition.manage.vo.CmsSubjectDictVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author DKwms
 * @Date 2024/1/16 16:53
 * @description
 */

@FeignClient(value = "pguide-competition-manage",contextId = "CMSSubjectDictClient")
public interface CMSSubjectDictClient {

    /**
     * 返回学科字典表
     *
     * 返回学生字典表信息
     */
    @RequestMapping("/competition/dict")
    JsonResult<Map<Integer, List<CmsSubjectDictVo>>> getDict();
}
