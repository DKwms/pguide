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
import org.pguide.mms.manage.domain.MmsNeedRecruitInfo;
import org.pguide.mms.manage.service.IMmsNeedRecruitInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目需求招募信息Controller
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/manage/recruitinfo")
public class MmsNeedRecruitInfoController extends BaseController
{
    @Autowired
    private IMmsNeedRecruitInfoService mmsNeedRecruitInfoService;

    /**
     * 查询项目需求招募信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:recruitinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MmsNeedRecruitInfo mmsNeedRecruitInfo)
    {
        startPage();
        List<MmsNeedRecruitInfo> list = mmsNeedRecruitInfoService.selectMmsNeedRecruitInfoList(mmsNeedRecruitInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目需求招募信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:recruitinfo:export')")
    @Log(title = "项目需求招募信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsNeedRecruitInfo mmsNeedRecruitInfo)
    {
        List<MmsNeedRecruitInfo> list = mmsNeedRecruitInfoService.selectMmsNeedRecruitInfoList(mmsNeedRecruitInfo);
        ExcelUtil<MmsNeedRecruitInfo> util = new ExcelUtil<MmsNeedRecruitInfo>(MmsNeedRecruitInfo.class);
        util.exportExcel(response, list, "项目需求招募信息数据");
    }

    /**
     * 获取项目需求招募信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:recruitinfo:query')")
    @GetMapping(value = "/{recruitId}")
    public AjaxResult getInfo(@PathVariable("recruitId") Long recruitId)
    {
        return success(mmsNeedRecruitInfoService.selectMmsNeedRecruitInfoByRecruitId(recruitId));
    }

    /**
     * 新增项目需求招募信息
     */
    @PreAuthorize("@ss.hasPermi('manage:recruitinfo:add')")
    @Log(title = "项目需求招募信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsNeedRecruitInfo mmsNeedRecruitInfo)
    {
        return toAjax(mmsNeedRecruitInfoService.insertMmsNeedRecruitInfo(mmsNeedRecruitInfo));
    }

    /**
     * 修改项目需求招募信息
     */
    @PreAuthorize("@ss.hasPermi('manage:recruitinfo:edit')")
    @Log(title = "项目需求招募信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsNeedRecruitInfo mmsNeedRecruitInfo)
    {
        return toAjax(mmsNeedRecruitInfoService.updateMmsNeedRecruitInfo(mmsNeedRecruitInfo));
    }

    /**
     * 删除项目需求招募信息
     */
    @PreAuthorize("@ss.hasPermi('manage:recruitinfo:remove')")
    @Log(title = "项目需求招募信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recruitIds}")
    public AjaxResult remove(@PathVariable Long[] recruitIds)
    {
        return toAjax(mmsNeedRecruitInfoService.deleteMmsNeedRecruitInfoByRecruitIds(recruitIds));
    }
}
