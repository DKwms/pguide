package org.pguide.provider.index.info.controller;

import org.pguide.common.core.result.JsonResult;
import org.pguide.entity.index.info.entity.IndexPartboxInfo;
import org.pguide.index.info.service.IndexPartboxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DKwms
 * @Date 2023/12/2 17:48
 * @description
 */
@RestController
@RequestMapping("/api/index/info/carousel")
public class IndexInfoCarousel {

    @Autowired
    IndexPartboxInfoService indexPartboxInfoService;

    /**
     * 获取轮播图列表
     */
    @GetMapping
    public JsonResult<List<IndexPartboxInfo>> testTest(){
        List<IndexPartboxInfo> list = indexPartboxInfoService.list();
        return JsonResult.success(list);
    }

}
