package com.pguide.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pguide.project.mapper.ProjectTaskReceiverMapper;
import com.pguide.project.domain.ProjectTaskReceiver;
import com.pguide.project.service.IProjectTaskReceiverService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@Service
public class ProjectTaskReceiverServiceImpl implements IProjectTaskReceiverService 
{
    @Autowired
    private ProjectTaskReceiverMapper projectTaskReceiverMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ProjectTaskReceiver selectProjectTaskReceiverByTaskId(Long taskId)
    {
        return projectTaskReceiverMapper.selectProjectTaskReceiverByTaskId(taskId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param projectTaskReceiver 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ProjectTaskReceiver> selectProjectTaskReceiverList(ProjectTaskReceiver projectTaskReceiver)
    {
        return projectTaskReceiverMapper.selectProjectTaskReceiverList(projectTaskReceiver);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param projectTaskReceiver 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertProjectTaskReceiver(ProjectTaskReceiver projectTaskReceiver)
    {
        return projectTaskReceiverMapper.insertProjectTaskReceiver(projectTaskReceiver);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param projectTaskReceiver 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateProjectTaskReceiver(ProjectTaskReceiver projectTaskReceiver)
    {
        return projectTaskReceiverMapper.updateProjectTaskReceiver(projectTaskReceiver);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param taskIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProjectTaskReceiverByTaskIds(Long[] taskIds)
    {
        return projectTaskReceiverMapper.deleteProjectTaskReceiverByTaskIds(taskIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProjectTaskReceiverByTaskId(Long taskId)
    {
        return projectTaskReceiverMapper.deleteProjectTaskReceiverByTaskId(taskId);
    }
}
