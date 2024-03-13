package com.pguide.project.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pguide.project.controller.dto.ProjectLogAllInfoDto;
import com.pguide.project.domain.result.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.pguide.project.domain.ProjectLogDetail;
import com.pguide.project.service.IProjectLogDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@RestController
@RequestMapping("/project/detail")
public class ProjectLogDetailController
{
    @Resource
    private IProjectLogDetailService projectLogDetailService;
    /**
     * 返回全部日志信息到前端
     * @return
     */
    @GetMapping("/list")
    public R<ArrayList<ArrayList<ProjectLogAllInfoDto>>> list(){
        return new R(projectLogDetailService.selectProjectLogInfoList());
    }

    // @GetMapping("/page")
    // public ArrayList<ArrayList<ProjectLogAllInfoDto>> logPage( @RequestParam int ){
    //     return null;
    // }
}
