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
import org.pguide.mms.manage.domain.MmsProjectInfo;
import org.pguide.mms.manage.service.IMmsProjectInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目信息主表Controller
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/manage/projectinfo")
public class MmsProjectInfoController extends BaseController
{
    @Autowired
    private IMmsProjectInfoService mmsProjectInfoService;

    /**
     * 查询项目信息主表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:projectinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MmsProjectInfo mmsProjectInfo)
    {
        startPage();
        List<MmsProjectInfo> list = mmsProjectInfoService.selectMmsProjectInfoList(mmsProjectInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目信息主表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:projectinfo:export')")
    @Log(title = "项目信息主表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsProjectInfo mmsProjectInfo)
    {
        List<MmsProjectInfo> list = mmsProjectInfoService.selectMmsProjectInfoList(mmsProjectInfo);
        ExcelUtil<MmsProjectInfo> util = new ExcelUtil<MmsProjectInfo>(MmsProjectInfo.class);
        util.exportExcel(response, list, "项目信息主表数据");
    }

    /**
     * 获取项目信息主表详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:projectinfo:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return success(mmsProjectInfoService.selectMmsProjectInfoByProjectId(projectId));
    }

    /**
     * 新增项目信息主表
     */
    @PreAuthorize("@ss.hasPermi('manage:projectinfo:add')")
    @Log(title = "项目信息主表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsProjectInfo mmsProjectInfo)
    {
        return toAjax(mmsProjectInfoService.insertMmsProjectInfo(mmsProjectInfo));
    }

    /**
     * 修改项目信息主表
     */
    @PreAuthorize("@ss.hasPermi('manage:projectinfo:edit')")
    @Log(title = "项目信息主表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsProjectInfo mmsProjectInfo)
    {
        return toAjax(mmsProjectInfoService.updateMmsProjectInfo(mmsProjectInfo));
    }

    /**
     * 删除项目信息主表
     */
    @PreAuthorize("@ss.hasPermi('manage:projectinfo:remove')")
    @Log(title = "项目信息主表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(mmsProjectInfoService.deleteMmsProjectInfoByProjectIds(projectIds));
    }
}
