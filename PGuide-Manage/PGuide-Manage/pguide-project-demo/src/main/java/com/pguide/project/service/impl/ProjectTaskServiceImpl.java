package com.pguide.project.service.impl;

import java.util.List;

import com.pguide.project.controller.dto.ProjectTaskDto;
import com.pguide.project.controller.vo.ProjectTaskAddVo;
import com.pguide.project.domain.ProjectTaskReceiver;
import com.pguide.project.mapper.ProjectTaskReceiverMapper;
import com.pguide.project.mapper.ProjectTaskTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pguide.project.mapper.ProjectTaskMapper;
import com.pguide.project.domain.ProjectTask;
import com.pguide.project.service.IProjectTaskService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@Service
public class ProjectTaskServiceImpl implements IProjectTaskService 
{
    @Autowired
    private ProjectTaskMapper projectTaskMapper;

    @Autowired
    private ProjectTaskReceiverMapper projectTaskReceiverMapper;

    @Autowired
    private ProjectTaskTagMapper projectTaskTagMapper;

    @Override
    public List<ProjectTaskDto> getProjectTaskDto(Long userId) {
        // 查询权限范围内的接收
        List<Long> taskIdByUser = projectTaskReceiverMapper.getTaskIdByUser(userId);
        List<ProjectTaskDto> projectTaskDtosList = projectTaskMapper.getTaskDtosByTaskId(taskIdByUser);
        return projectTaskDtosList;
    }

    /**
     * 查询【请填写功能名称】
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ProjectTask selectProjectTaskByTaskId(Long taskId)
    {
        return projectTaskMapper.selectProjectTaskByTaskId(taskId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param projectTask 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ProjectTask> selectProjectTaskList(ProjectTask projectTask)
    {
        return projectTaskMapper.selectProjectTaskList(projectTask);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param projectTask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertProjectTask(ProjectTask projectTask)
    {
        return projectTaskMapper.insertProjectTask(projectTask);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param projectTask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateProjectTask(ProjectTask projectTask)
    {
        return projectTaskMapper.updateProjectTask(projectTask);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param taskIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProjectTaskByTaskIds(Long[] taskIds)
    {
        return projectTaskMapper.deleteProjectTaskByTaskIds(taskIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProjectTaskByTaskId(Long taskId)
    {
        return projectTaskMapper.deleteProjectTaskByTaskId(taskId);
    }

    @Override
    public int addFormVo(ProjectTaskAddVo adder) {
        projectTaskMapper.addFormVo(adder);
        return adder.getId();
    }
}
