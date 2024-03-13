package org.pguide.demo.page.controller;

import com.github.pagehelper.PageHelper;
import org.pguide.common.core.result.JsonResult;
import org.pguide.common.page.annotation.EasyPage;
import org.pguide.common.page.utils.PageUtil;
import org.pguide.common.page.utils.PageVo;
import org.pguide.project.match.entity.MmsProjectInfo;
import org.pguide.project.match.entity.MmsProjectStatusDict;
import org.pguide.project.match.service.MmsProjectStatusDictService;
import org.pguide.project.match.service.impl.MmsProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/2/6 17:03
 * @description
 */


@RestController
@ResponseBody
public class DemoController {

    @Autowired
    MmsProjectInfoServiceImpl mmsProjectInfoService;

    @Autowired
    MmsProjectStatusDictService mmsProjectStatusDictService;

    @GetMapping("test")
    @EasyPage
    public JsonResult<PageVo> test(){
        List<MmsProjectInfo> list = mmsProjectInfoService.list();
        return PageUtil.getPageResult(list);
    }

    @GetMapping("test2")
    @EasyPage
    public JsonResult<PageVo> test2(){
        List<MmsProjectStatusDict> list = mmsProjectStatusDictService.list();
        return PageUtil.getPageResult(list);
    }

}
