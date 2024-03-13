package com.pguide.project.controller;


import com.pguide.project.controller.dto.ProjectLogAllInfoDto;
import com.pguide.project.controller.vo.ProjectLogVo;
import com.pguide.project.domain.result.R;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.pguide.project.service.IProjectLogTopService;

import java.util.ArrayList;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@RestController
@RequestMapping("/project/top")
public class ProjectLogTopController extends BaseController
{
    @Autowired
    private IProjectLogTopService projectLogTopService;

    /**
     * 根据条件进行分页查询，后续可以加上判断语句，来转接到各个不同层面的条件 TODO
     * @param vo
     * @return
     */
    @GetMapping("/page")
    public R<ArrayList<ArrayList<ProjectLogAllInfoDto>>> selectLogPage(@ModelAttribute ProjectLogVo vo){
        System.out.println(vo);
        return new R<>(projectLogTopService.selectLogPage(vo));
    }
}
