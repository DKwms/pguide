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
import org.pguide.cms.manage.domain.CmsOrgDict;
import org.pguide.cms.manage.service.ICmsOrgDictService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 组织字典Controller
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/cmsmanage/orgdict")
public class CmsOrgDictController extends BaseController
{
    @Autowired
    private ICmsOrgDictService cmsOrgDictService;

    /**
     * 查询组织字典列表
     */
    @PreAuthorize("@ss.hasPermi('manage:orgdict:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsOrgDict cmsOrgDict)
    {
        startPage();
        List<CmsOrgDict> list = cmsOrgDictService.selectCmsOrgDictList(cmsOrgDict);
        return getDataTable(list);
    }

    /**
     * 导出组织字典列表
     */
    @PreAuthorize("@ss.hasPermi('manage:orgdict:export')")
    @Log(title = "组织字典", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsOrgDict cmsOrgDict)
    {
        List<CmsOrgDict> list = cmsOrgDictService.selectCmsOrgDictList(cmsOrgDict);
        ExcelUtil<CmsOrgDict> util = new ExcelUtil<CmsOrgDict>(CmsOrgDict.class);
        util.exportExcel(response, list, "组织字典数据");
    }

    /**
     * 获取组织字典详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:orgdict:query')")
    @GetMapping(value = "/{orgId}")
    public AjaxResult getInfo(@PathVariable("orgId") Long orgId)
    {
        return success(cmsOrgDictService.selectCmsOrgDictByOrgId(orgId));
    }

    /**
     * 新增组织字典
     */
    @PreAuthorize("@ss.hasPermi('manage:orgdict:add')")
    @Log(title = "组织字典", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsOrgDict cmsOrgDict)
    {
        return toAjax(cmsOrgDictService.insertCmsOrgDict(cmsOrgDict));
    }

    /**
     * 修改组织字典
     */
    @PreAuthorize("@ss.hasPermi('manage:orgdict:edit')")
    @Log(title = "组织字典", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsOrgDict cmsOrgDict)
    {
        return toAjax(cmsOrgDictService.updateCmsOrgDict(cmsOrgDict));
    }

    /**
     * 删除组织字典
     */
    @PreAuthorize("@ss.hasPermi('manage:orgdict:remove')")
    @Log(title = "组织字典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orgIds}")
    public AjaxResult remove(@PathVariable Long[] orgIds)
    {
        return toAjax(cmsOrgDictService.deleteCmsOrgDictByOrgIds(orgIds));
    }
}
