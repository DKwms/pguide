package com.pguide.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pguide.project.mapper.ProjectTaskTagMapper;
import com.pguide.project.domain.ProjectTaskTag;
import com.pguide.project.service.IProjectTaskTagService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@Service
public class ProjectTaskTagServiceImpl implements IProjectTaskTagService 
{
    @Autowired
    private ProjectTaskTagMapper projectTaskTagMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param tagsId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ProjectTaskTag selectProjectTaskTagByTagsId(Long tagsId)
    {
        return projectTaskTagMapper.selectProjectTaskTagByTagsId(tagsId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param projectTaskTag 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ProjectTaskTag> selectProjectTaskTagList(ProjectTaskTag projectTaskTag)
    {
        return projectTaskTagMapper.selectProjectTaskTagList(projectTaskTag);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param projectTaskTag 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertProjectTaskTag(ProjectTaskTag projectTaskTag)
    {
        return projectTaskTagMapper.insertProjectTaskTag(projectTaskTag);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param projectTaskTag 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateProjectTaskTag(ProjectTaskTag projectTaskTag)
    {
        return projectTaskTagMapper.updateProjectTaskTag(projectTaskTag);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param tagsIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProjectTaskTagByTagsIds(Long[] tagsIds)
    {
        return projectTaskTagMapper.deleteProjectTaskTagByTagsIds(tagsIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param tagsId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProjectTaskTagByTagsId(Long tagsId)
    {
        return projectTaskTagMapper.deleteProjectTaskTagByTagsId(tagsId);
    }
}
