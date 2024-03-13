package org.pguide.competition.manage.feign;

import org.pguide.common.core.result.JsonResult;
import org.pguide.competition.manage.api.fegin.CMSSubjectDictClient;
import org.pguide.competition.manage.service.CmsSubjectDictService;
import org.pguide.competition.manage.service.impl.CmsSubjectDictServiceImpl;
import org.pguide.competition.manage.vo.CmsSubjectDictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author DKwms
 * @Date 2024/1/16 17:08
 * @description 返回学科信息
 */

@RestController
@RequestMapping("/api/feign/cms")
public class CMSSubjectDictController implements CMSSubjectDictClient {

    @Autowired
    CmsSubjectDictServiceImpl cmsSubjectDictService;



    @Override
    public JsonResult<Map<Integer, List<CmsSubjectDictVo>>> getDict() {
        return JsonResult.success(cmsSubjectDictService.getSubjectTree());
    }


}
