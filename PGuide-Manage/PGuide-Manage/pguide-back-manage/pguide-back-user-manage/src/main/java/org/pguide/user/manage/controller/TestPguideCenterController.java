package org.pguide.user.manage.controller;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.pguide.user.manage.entity.UsercenterStudentInfo;
import org.pguide.user.manage.service.impl.UsercenterStudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DKwms
 * @Date 2023/12/31 13:38
 * @description
 */

@RestController
@Controller
@Slf4j
@ResponseBody
@RequestMapping("/api/test")
@DataSource(value = DataSourceType.USER)
public class TestPguideCenterController {

    @Autowired
    UsercenterStudentInfoServiceImpl usercenterStudentInfoService;

}
