package org.pguide.cms.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import org.pguide.cms.manage.domain.CmsCptInfo;
import org.pguide.cms.manage.service.ICmsCptInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 比赛信息Controller
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/cmsmanage/cptinfo")

public class CmsCptInfoController extends BaseController
{
    @Autowired
    private ICmsCptInfoService cmsCptInfoService;

    /**
     * 查询比赛信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:cptinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsCptInfo cmsCptInfo)
    {
        startPage();
        List<CmsCptInfo> list = cmsCptInfoService.selectCmsCptInfoList(cmsCptInfo);
        return getDataTable(list);
    }

    /**
     * 导出比赛信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:cptinfo:export')")
    @Log(title = "比赛信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsCptInfo cmsCptInfo)
    {
        List<CmsCptInfo> list = cmsCptInfoService.selectCmsCptInfoList(cmsCptInfo);
        ExcelUtil<CmsCptInfo> util = new ExcelUtil<CmsCptInfo>(CmsCptInfo.class);
        util.exportExcel(response, list, "比赛信息数据");
    }

    /**
     * 获取比赛信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:cptinfo:query')")
    @GetMapping(value = "/{cptId}")
    public AjaxResult getInfo(@PathVariable("cptId") Long cptId)
    {
        return success(cmsCptInfoService.selectCmsCptInfoByCptId(cptId));
    }

    /**
     * 新增比赛信息
     */
    @PreAuthorize("@ss.hasPermi('manage:cptinfo:add')")
    @Log(title = "比赛信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsCptInfo cmsCptInfo)
    {
        return toAjax(cmsCptInfoService.insertCmsCptInfo(cmsCptInfo));
    }

    /**
     * 修改比赛信息
     */
    @PreAuthorize("@ss.hasPermi('manage:cptinfo:edit')")
    @Log(title = "比赛信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsCptInfo cmsCptInfo)
    {
        return toAjax(cmsCptInfoService.updateCmsCptInfo(cmsCptInfo));
    }

    /**
     * 删除比赛信息
     */
    @PreAuthorize("@ss.hasPermi('manage:cptinfo:remove')")
    @Log(title = "比赛信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cptIds}")
    public AjaxResult remove(@PathVariable Long[] cptIds)
    {
        return toAjax(cmsCptInfoService.deleteCmsCptInfoByCptIds(cptIds));
    }
}
