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
import com.pguide.project.domain.ProjectTaskTag;
import com.pguide.project.service.IProjectTaskTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@RestController
@RequestMapping("/project/tag")
public class ProjectTaskTagController extends BaseController
{
    @Autowired
    private IProjectTaskTagService projectTaskTagService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectTaskTag projectTaskTag)
    {
        startPage();
        List<ProjectTaskTag> list = projectTaskTagService.selectProjectTaskTagList(projectTaskTag);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:tag:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjectTaskTag projectTaskTag)
    {
        List<ProjectTaskTag> list = projectTaskTagService.selectProjectTaskTagList(projectTaskTag);
        ExcelUtil<ProjectTaskTag> util = new ExcelUtil<ProjectTaskTag>(ProjectTaskTag.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:tag:query')")
    @GetMapping(value = "/{tagsId}")
    public AjaxResult getInfo(@PathVariable("tagsId") Long tagsId)
    {
        return success(projectTaskTagService.selectProjectTaskTagByTagsId(tagsId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:tag:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectTaskTag projectTaskTag)
    {
        return toAjax(projectTaskTagService.insertProjectTaskTag(projectTaskTag));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:tag:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectTaskTag projectTaskTag)
    {
        return toAjax(projectTaskTagService.updateProjectTaskTag(projectTaskTag));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:tag:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tagsIds}")
    public AjaxResult remove(@PathVariable Long[] tagsIds)
    {
        return toAjax(projectTaskTagService.deleteProjectTaskTagByTagsIds(tagsIds));
    }
}
