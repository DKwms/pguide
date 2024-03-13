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
import org.pguide.cms.manage.domain.CmsSubjectDict;
import org.pguide.cms.manage.service.ICmsSubjectDictService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学科字典Controller
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/cmsmanage/subjectdict")
public class CmsSubjectDictController extends BaseController
{
    @Autowired
    private ICmsSubjectDictService cmsSubjectDictService;

    /**
     * 查询学科字典列表
     */
    @PreAuthorize("@ss.hasPermi('manage:subjectdict:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsSubjectDict cmsSubjectDict)
    {
        startPage();
        List<CmsSubjectDict> list = cmsSubjectDictService.selectCmsSubjectDictList(cmsSubjectDict);
        return getDataTable(list);
    }

    /**
     * 导出学科字典列表
     */
    @PreAuthorize("@ss.hasPermi('manage:subjectdict:export')")
    @Log(title = "学科字典", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsSubjectDict cmsSubjectDict)
    {
        List<CmsSubjectDict> list = cmsSubjectDictService.selectCmsSubjectDictList(cmsSubjectDict);
        ExcelUtil<CmsSubjectDict> util = new ExcelUtil<CmsSubjectDict>(CmsSubjectDict.class);
        util.exportExcel(response, list, "学科字典数据");
    }

    /**
     * 获取学科字典详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:subjectdict:query')")
    @GetMapping(value = "/{subjectId}")
    public AjaxResult getInfo(@PathVariable("subjectId") Long subjectId)
    {
        return success(cmsSubjectDictService.selectCmsSubjectDictBySubjectId(subjectId));
    }

    /**
     * 新增学科字典
     */
    @PreAuthorize("@ss.hasPermi('manage:subjectdict:add')")
    @Log(title = "学科字典", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsSubjectDict cmsSubjectDict)
    {
        return toAjax(cmsSubjectDictService.insertCmsSubjectDict(cmsSubjectDict));
    }

    /**
     * 修改学科字典
     */
    @PreAuthorize("@ss.hasPermi('manage:subjectdict:edit')")
    @Log(title = "学科字典", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsSubjectDict cmsSubjectDict)
    {
        return toAjax(cmsSubjectDictService.updateCmsSubjectDict(cmsSubjectDict));
    }

    /**
     * 删除学科字典
     */
    @PreAuthorize("@ss.hasPermi('manage:subjectdict:remove')")
    @Log(title = "学科字典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{subjectIds}")
    public AjaxResult remove(@PathVariable Long[] subjectIds)
    {
        return toAjax(cmsSubjectDictService.deleteCmsSubjectDictBySubjectIds(subjectIds));
    }
}
