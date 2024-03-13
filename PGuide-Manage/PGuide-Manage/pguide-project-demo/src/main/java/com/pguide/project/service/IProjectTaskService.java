package com.pguide.project.service;

import java.util.List;

import com.pguide.project.controller.dto.ProjectTaskDto;
import com.pguide.project.controller.vo.ProjectTaskAddVo;
import com.pguide.project.domain.ProjectTask;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public interface IProjectTaskService 
{


    /**
     * 更具用户id，给与任务单的前几个，进行任务列表的展示
     */
    public List<ProjectTaskDto> getProjectTaskDto(Long userId);

    /**
     * 查询【请填写功能名称】
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ProjectTask selectProjectTaskByTaskId(Long taskId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param projectTask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ProjectTask> selectProjectTaskList(ProjectTask projectTask);

    /**
     * 新增【请填写功能名称】
     * 
     * @param projectTask 【请填写功能名称】
     * @return 结果
     */
    public int insertProjectTask(ProjectTask projectTask);

    /**
     * 修改【请填写功能名称】
     * 
     * @param projectTask 【请填写功能名称】
     * @return 结果
     */
    public int updateProjectTask(ProjectTask projectTask);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param taskIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteProjectTaskByTaskIds(Long[] taskIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteProjectTaskByTaskId(Long taskId);

    int addFormVo(ProjectTaskAddVo adder);
}
