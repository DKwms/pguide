package org.pguide.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.pguide.common.core.result.JsonResult;
import org.pguide.user.entity.UsercenterStudentInfo;
import org.pguide.user.service.impl.UsercenterStudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DKwms
 * @Date 2023/12/31 13:23
 * @description
 */

@RestController
@ResponseBody
@RequestMapping("/api/pguide/usercenter/test")
@Slf4j
public class BaseTestController {

    @Autowired
    UsercenterStudentInfoServiceImpl usercenterStudentInfoService;

    @GetMapping
    public JsonResult<List<UsercenterStudentInfo>> test(){
        log.info("成功映射");
        List<UsercenterStudentInfo> list = usercenterStudentInfoService.list();
        return JsonResult.success(list);
    }
}
