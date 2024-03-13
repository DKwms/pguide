package com.pguide.project.controller;

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
import com.pguide.project.domain.ProjectTaskReceiver;
import com.pguide.project.service.IProjectTaskReceiverService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@RestController
@RequestMapping("/project/receiver")
public class ProjectTaskReceiverController extends BaseController
{
    @Autowired
    private IProjectTaskReceiverService projectTaskReceiverService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:receiver:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectTaskReceiver projectTaskReceiver)
    {
        startPage();
        List<ProjectTaskReceiver> list = projectTaskReceiverService.selectProjectTaskReceiverList(projectTaskReceiver);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:receiver:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjectTaskReceiver projectTaskReceiver)
    {
        List<ProjectTaskReceiver> list = projectTaskReceiverService.selectProjectTaskReceiverList(projectTaskReceiver);
        ExcelUtil<ProjectTaskReceiver> util = new ExcelUtil<ProjectTaskReceiver>(ProjectTaskReceiver.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:receiver:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(projectTaskReceiverService.selectProjectTaskReceiverByTaskId(taskId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:receiver:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectTaskReceiver projectTaskReceiver)
    {
        return toAjax(projectTaskReceiverService.insertProjectTaskReceiver(projectTaskReceiver));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:receiver:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectTaskReceiver projectTaskReceiver)
    {
        return toAjax(projectTaskReceiverService.updateProjectTaskReceiver(projectTaskReceiver));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:receiver:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(projectTaskReceiverService.deleteProjectTaskReceiverByTaskIds(taskIds));
    }
}
