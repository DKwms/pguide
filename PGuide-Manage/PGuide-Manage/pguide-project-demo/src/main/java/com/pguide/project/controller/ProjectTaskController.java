package com.pguide.project.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.pguide.project.controller.dto.ProjectTaskDto;
import com.pguide.project.controller.vo.ProjectTaskAddVo;
import com.pguide.project.domain.SysRoleTask;
import com.pguide.project.service.SysRoleTaskService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.pguide.project.domain.ProjectTask;
import com.pguide.project.service.IProjectTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@RestController
@RequestMapping("/project/task")
public class ProjectTaskController extends BaseController
{
    @Autowired
    private IProjectTaskService projectTaskService;

    @Autowired
    private SysRoleTaskService sysRoleTaskService;

    /**
     * 获取用户对应的
     */

    @GetMapping("/list/self")
    public AjaxResult listSelf(){
        Long userId = SecurityUtils.getUserId();
        List<ProjectTaskDto> projectTaskDto = projectTaskService.getProjectTaskDto(userId);
        return AjaxResult.success(projectTaskDto);
    }

    /**
     * 新增task
     * 同时关联role:task表进行新增
     */
    @PostMapping("/add/mut")
    @Transactional
    public AjaxResult baseAddRoleMethods(@RequestBody ProjectTaskAddVo adder){
        System.out.println(adder);
        // add task
        //get the auto ID
        int newId = projectTaskService.addFormVo(adder);
        // add role : task DICT
        SysRoleTask build = SysRoleTask.builder()
                .roleId(String.valueOf(adder.getOptionResult()))
                .taskId(newId)
                .build();

        sysRoleTaskService.saveOrUpdate(build);

        return AjaxResult.success("insert success!");
    }


    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectTask projectTask)
    {
        startPage();
        List<ProjectTask> list = projectTaskService.selectProjectTaskList(projectTask);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:task:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjectTask projectTask)
    {
        List<ProjectTask> list = projectTaskService.selectProjectTaskList(projectTask);
        ExcelUtil<ProjectTask> util = new ExcelUtil<ProjectTask>(ProjectTask.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(projectTaskService.selectProjectTaskByTaskId(taskId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:task:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectTask projectTask)
    {
        return toAjax(projectTaskService.insertProjectTask(projectTask));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:task:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectTask projectTask)
    {
        return toAjax(projectTaskService.updateProjectTask(projectTask));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:task:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(projectTaskService.deleteProjectTaskByTaskIds(taskIds));
    }
}
