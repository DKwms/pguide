package org.pguide.competition.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.pguide.common.core.result.JsonResult;
import org.pguide.competition.manage.service.impl.CmsSubjectDictServiceImpl;
import org.pguide.competition.manage.vo.CmsSubjectDictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author DKwms
 * @Date 2024/1/17 11:10
 * @description
 */
@RequestMapping("/api/cms")
@RestController
@Slf4j
public class CMSMatchUiSubjectController {

    @Autowired
    CmsSubjectDictServiceImpl cmsSubjectDictService;

    @GetMapping("/subject/tree")
    public JsonResult<Map<Integer, List<CmsSubjectDictVo>>> getSubjectTree(){
        return JsonResult.success(cmsSubjectDictService.getSubjectTree());
    }
}
