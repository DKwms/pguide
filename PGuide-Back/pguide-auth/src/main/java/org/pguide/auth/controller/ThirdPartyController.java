package org.pguide.auth.controller;


import org.pguide.common.core.result.JsonResult;
import org.pguide.user.service.ThirdPartyLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DKwms
 * @Date 2023/9/18 22:13
 * @description
 */

@RestController
@RequestMapping("/api/auth/third")
public class ThirdPartyController {

    @Autowired
    ThirdPartyLoginService thirdPartyLoginService;

    /**
     * 获取所有第三方组件信息
     */
    @GetMapping
    public JsonResult getList(){
        return JsonResult.success(thirdPartyLoginService.list());
    }
}
