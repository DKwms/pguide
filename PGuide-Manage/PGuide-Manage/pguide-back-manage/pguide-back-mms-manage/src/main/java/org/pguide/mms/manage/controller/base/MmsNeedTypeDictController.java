package org.pguide.mms.manage.controller.base;

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
import org.pguide.mms.manage.domain.MmsNeedTypeDict;
import org.pguide.mms.manage.service.IMmsNeedTypeDictService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 需求类型字典表Controller
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/manage/needtypedict")
public class MmsNeedTypeDictController extends BaseController
{
    @Autowired
    private IMmsNeedTypeDictService mmsNeedTypeDictService;

    /**
     * 查询需求类型字典表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:needtypedict:list')")
    @GetMapping("/list")
    public TableDataInfo list(MmsNeedTypeDict mmsNeedTypeDict)
    {
        startPage();
        List<MmsNeedTypeDict> list = mmsNeedTypeDictService.selectMmsNeedTypeDictList(mmsNeedTypeDict);
        return getDataTable(list);
    }

    /**
     * 导出需求类型字典表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:needtypedict:export')")
    @Log(title = "需求类型字典表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsNeedTypeDict mmsNeedTypeDict)
    {
        List<MmsNeedTypeDict> list = mmsNeedTypeDictService.selectMmsNeedTypeDictList(mmsNeedTypeDict);
        ExcelUtil<MmsNeedTypeDict> util = new ExcelUtil<MmsNeedTypeDict>(MmsNeedTypeDict.class);
        util.exportExcel(response, list, "需求类型字典表数据");
    }

    /**
     * 获取需求类型字典表详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:needtypedict:query')")
    @GetMapping(value = "/{needTypeId}")
    public AjaxResult getInfo(@PathVariable("needTypeId") Long needTypeId)
    {
        return success(mmsNeedTypeDictService.selectMmsNeedTypeDictByNeedTypeId(needTypeId));
    }

    /**
     * 新增需求类型字典表
     */
    @PreAuthorize("@ss.hasPermi('manage:needtypedict:add')")
    @Log(title = "需求类型字典表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsNeedTypeDict mmsNeedTypeDict)
    {
        return toAjax(mmsNeedTypeDictService.insertMmsNeedTypeDict(mmsNeedTypeDict));
    }

    /**
     * 修改需求类型字典表
     */
    @PreAuthorize("@ss.hasPermi('manage:needtypedict:edit')")
    @Log(title = "需求类型字典表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsNeedTypeDict mmsNeedTypeDict)
    {
        return toAjax(mmsNeedTypeDictService.updateMmsNeedTypeDict(mmsNeedTypeDict));
    }

    /**
     * 删除需求类型字典表
     */
    @PreAuthorize("@ss.hasPermi('manage:needtypedict:remove')")
    @Log(title = "需求类型字典表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{needTypeIds}")
    public AjaxResult remove(@PathVariable Long[] needTypeIds)
    {
        return toAjax(mmsNeedTypeDictService.deleteMmsNeedTypeDictByNeedTypeIds(needTypeIds));
    }
}
