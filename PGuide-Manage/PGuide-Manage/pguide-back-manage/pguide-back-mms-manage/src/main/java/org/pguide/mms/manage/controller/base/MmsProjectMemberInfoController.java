package org.pguide.mms.manage.controller.base;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
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
import org.pguide.mms.manage.domain.MmsProjectMemberInfo;
import org.pguide.mms.manage.service.IMmsProjectMemberInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目成员信息表Controller
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/manage/memberinfo")
@Slf4j
public class MmsProjectMemberInfoController extends BaseController
{
    @Autowired
    private IMmsProjectMemberInfoService mmsProjectMemberInfoService;

    /**
     * 查询项目成员信息表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:memberinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MmsProjectMemberInfo mmsProjectMemberInfo)
    {
        startPage();
        new Thread(()->{
            log.info("进入项目成员列表操作");
        }).start();
        List<MmsProjectMemberInfo> list = mmsProjectMemberInfoService.selectMmsProjectMemberInfoList(mmsProjectMemberInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目成员信息表列表
     */
    @PreAuthorize("@ss.hasPermi('manage:memberinfo:export')")
    @Log(title = "项目成员信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MmsProjectMemberInfo mmsProjectMemberInfo)
    {
        List<MmsProjectMemberInfo> list = mmsProjectMemberInfoService.selectMmsProjectMemberInfoList(mmsProjectMemberInfo);
        ExcelUtil<MmsProjectMemberInfo> util = new ExcelUtil<MmsProjectMemberInfo>(MmsProjectMemberInfo.class);
        util.exportExcel(response, list, "项目成员信息表数据");
    }

    /**
     * 获取项目成员信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:memberinfo:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return success(mmsProjectMemberInfoService.selectMmsProjectMemberInfoByProjectId(projectId));
    }

    /**
     * 新增项目成员信息表
     */
    @PreAuthorize("@ss.hasPermi('manage:memberinfo:add')")
    @Log(title = "项目成员信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MmsProjectMemberInfo mmsProjectMemberInfo)
    {
        return toAjax(mmsProjectMemberInfoService.insertMmsProjectMemberInfo(mmsProjectMemberInfo));
    }

    /**
     * 修改项目成员信息表
     */
    @PreAuthorize("@ss.hasPermi('manage:memberinfo:edit')")
    @Log(title = "项目成员信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MmsProjectMemberInfo mmsProjectMemberInfo)
    {
        return toAjax(mmsProjectMemberInfoService.updateMmsProjectMemberInfo(mmsProjectMemberInfo));
    }

    /**
     * 删除项目成员信息表
     */
    @PreAuthorize("@ss.hasPermi('manage:memberinfo:remove')")
    @Log(title = "项目成员信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(mmsProjectMemberInfoService.deleteMmsProjectMemberInfoByProjectIds(projectIds));
    }
}
