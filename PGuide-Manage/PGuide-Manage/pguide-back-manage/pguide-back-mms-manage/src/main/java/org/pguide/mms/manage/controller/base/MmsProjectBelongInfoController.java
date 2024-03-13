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
import org.pguide.mms.manage.domain.MmsProjectBelongInfo;
import org.pguide.mms.manage.service.IMmsProjectBelongInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目从属信息表Controller
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/manage/belonginfo")
public class MmsProjectBelongInfoController extends BaseController
{
    @Autowired
    private IMmsProjectBelongInfoService mmsProjectBelongInfoService;

    /**
     * 查询项目从属信息表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:belonginfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MmsProjectBelongInfo mmsProjectBelongInfo)
    {
        startPage();
        List<MmsProjectBelongInfo> list = mmsProjectBelongInfoService.selectMmsProjectBelongInfoList(mmsProjectBelongInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目从属信息表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:belonginfo:export')")
    @Log(title = "项目从属信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsProjectBelongInfo mmsProjectBelongInfo)
    {
        List<MmsProjectBelongInfo> list = mmsProjectBelongInfoService.selectMmsProjectBelongInfoList(mmsProjectBelongInfo);
        ExcelUtil<MmsProjectBelongInfo> util = new ExcelUtil<MmsProjectBelongInfo>(MmsProjectBelongInfo.class);
        util.exportExcel(response, list, "项目从属信息表数据");
    }

    /**
     * 获取项目从属信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:belonginfo:query')")
    @GetMapping(value = "/{belongId}")
    public AjaxResult getInfo(@PathVariable("belongId") Long belongId)
    {
        return success(mmsProjectBelongInfoService.selectMmsProjectBelongInfoByBelongId(belongId));
    }

    /**
     * 新增项目从属信息表
     */
    @PreAuthorize("@ss.hasPermi('manage:belonginfo:add')")
    @Log(title = "项目从属信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsProjectBelongInfo mmsProjectBelongInfo)
    {
        return toAjax(mmsProjectBelongInfoService.insertMmsProjectBelongInfo(mmsProjectBelongInfo));
    }

    /**
     * 修改项目从属信息表
     */
    @PreAuthorize("@ss.hasPermi('manage:belonginfo:edit')")
    @Log(title = "项目从属信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsProjectBelongInfo mmsProjectBelongInfo)
    {
        return toAjax(mmsProjectBelongInfoService.updateMmsProjectBelongInfo(mmsProjectBelongInfo));
    }

    /**
     * 删除项目从属信息表
     */
    @PreAuthorize("@ss.hasPermi('manage:belonginfo:remove')")
    @Log(title = "项目从属信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{belongIds}")
    public AjaxResult remove(@PathVariable Long[] belongIds)
    {
        return toAjax(mmsProjectBelongInfoService.deleteMmsProjectBelongInfoByBelongIds(belongIds));
    }
}
