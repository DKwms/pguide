package com.pguide.project.service;

import java.util.List;
import com.pguide.project.domain.ProjectTaskReceiver;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public interface IProjectTaskReceiverService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ProjectTaskReceiver selectProjectTaskReceiverByTaskId(Long taskId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param projectTaskReceiver 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ProjectTaskReceiver> selectProjectTaskReceiverList(ProjectTaskReceiver projectTaskReceiver);

    /**
     * 新增【请填写功能名称】
     * 
     * @param projectTaskReceiver 【请填写功能名称】
     * @return 结果
     */
    public int insertProjectTaskReceiver(ProjectTaskReceiver projectTaskReceiver);

    /**
     * 修改【请填写功能名称】
     * 
     * @param projectTaskReceiver 【请填写功能名称】
     * @return 结果
     */
    public int updateProjectTaskReceiver(ProjectTaskReceiver projectTaskReceiver);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param taskIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteProjectTaskReceiverByTaskIds(Long[] taskIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param taskId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteProjectTaskReceiverByTaskId(Long taskId);
}
