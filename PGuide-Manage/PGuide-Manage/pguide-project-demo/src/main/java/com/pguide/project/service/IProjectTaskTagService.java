package com.pguide.project.service;

import java.util.List;
import com.pguide.project.domain.ProjectTaskTag;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public interface IProjectTaskTagService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param tagsId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ProjectTaskTag selectProjectTaskTagByTagsId(Long tagsId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param projectTaskTag 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ProjectTaskTag> selectProjectTaskTagList(ProjectTaskTag projectTaskTag);

    /**
     * 新增【请填写功能名称】
     * 
     * @param projectTaskTag 【请填写功能名称】
     * @return 结果
     */
    public int insertProjectTaskTag(ProjectTaskTag projectTaskTag);

    /**
     * 修改【请填写功能名称】
     * 
     * @param projectTaskTag 【请填写功能名称】
     * @return 结果
     */
    public int updateProjectTaskTag(ProjectTaskTag projectTaskTag);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param tagsIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteProjectTaskTagByTagsIds(Long[] tagsIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param tagsId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteProjectTaskTagByTagsId(Long tagsId);
}
