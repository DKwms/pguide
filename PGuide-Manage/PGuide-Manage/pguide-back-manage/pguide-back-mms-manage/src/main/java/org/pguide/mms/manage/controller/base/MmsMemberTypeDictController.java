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
import org.pguide.mms.manage.domain.MmsMemberTypeDict;
import org.pguide.mms.manage.service.IMmsMemberTypeDictService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成员属性字典表Controller
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/manage/memtypedict")
public class MmsMemberTypeDictController extends BaseController
{
    @Autowired
    private IMmsMemberTypeDictService mmsMemberTypeDictService;

    /**
     * 查询成员属性字典表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:memtypedict:list')")
    @GetMapping("/list")
    public TableDataInfo list(MmsMemberTypeDict mmsMemberTypeDict)
    {
        startPage();
        List<MmsMemberTypeDict> list = mmsMemberTypeDictService.selectMmsMemberTypeDictList(mmsMemberTypeDict);
        return getDataTable(list);
    }

    /**
     * 导出成员属性字典表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:memtypedict:export')")
    @Log(title = "成员属性字典表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsMemberTypeDict mmsMemberTypeDict)
    {
        List<MmsMemberTypeDict> list = mmsMemberTypeDictService.selectMmsMemberTypeDictList(mmsMemberTypeDict);
        ExcelUtil<MmsMemberTypeDict> util = new ExcelUtil<MmsMemberTypeDict>(MmsMemberTypeDict.class);
        util.exportExcel(response, list, "成员属性字典表数据");
    }

    /**
     * 获取成员属性字典表详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:memtypedict:query')")
    @GetMapping(value = "/{memberTypeId}")
    public AjaxResult getInfo(@PathVariable("memberTypeId") Long memberTypeId)
    {
        return success(mmsMemberTypeDictService.selectMmsMemberTypeDictByMemberTypeId(memberTypeId));
    }

    /**
     * 新增成员属性字典表
     */
    @PreAuthorize("@ss.hasPermi('manage:memtypedict:add')")
    @Log(title = "成员属性字典表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsMemberTypeDict mmsMemberTypeDict)
    {
        return toAjax(mmsMemberTypeDictService.insertMmsMemberTypeDict(mmsMemberTypeDict));
    }

    /**
     * 修改成员属性字典表
     */
    @PreAuthorize("@ss.hasPermi('manage:memtypedict:edit')")
    @Log(title = "成员属性字典表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsMemberTypeDict mmsMemberTypeDict)
    {
        return toAjax(mmsMemberTypeDictService.updateMmsMemberTypeDict(mmsMemberTypeDict));
    }

    /**
     * 删除成员属性字典表
     */
    @PreAuthorize("@ss.hasPermi('manage:memtypedict:remove')")
    @Log(title = "成员属性字典表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memberTypeIds}")
    public AjaxResult remove(@PathVariable Long[] memberTypeIds)
    {
        return toAjax(mmsMemberTypeDictService.deleteMmsMemberTypeDictByMemberTypeIds(memberTypeIds));
    }
}
