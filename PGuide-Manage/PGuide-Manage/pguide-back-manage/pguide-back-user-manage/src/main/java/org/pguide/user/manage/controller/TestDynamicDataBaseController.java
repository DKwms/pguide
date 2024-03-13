package org.pguide.user.manage.controller;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.DataSourceType;
import org.pguide.user.manage.entity.ThirdPartyLogin;
import org.pguide.user.manage.service.impl.ThirdPartyLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DKwms
 * @Date 2023/12/30 21:08
 * @description
 */

@RequestMapping("/api/tddb")
@RestController
public class TestDynamicDataBaseController {

    @Autowired
    ThirdPartyLoginServiceImpl thirdPartyLoginService;

    @GetMapping
    @DataSource(value = DataSourceType.USER)
    public AjaxResult getList(){
        List<ThirdPartyLogin> list = thirdPartyLoginService.list();
        return AjaxResult.success(list);
    }

}
