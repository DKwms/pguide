package org.pguide.mms.manage.service;

import java.util.List;

import org.pguide.mms.manage.controller.publish.es.domain.dto.ProjectInfo;
import org.pguide.mms.manage.controller.publish.vo.ProjectPublishUpdatedVo;
import org.pguide.mms.manage.domain.MmsProjectInfo;

/**
 * 项目信息主表Service接口
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public interface IMmsProjectInfoService 
{
    /**
     * 查询项目信息主表
     * 
     * @param projectId 项目信息主表主键
     * @return 项目信息主表
     */
    public MmsProjectInfo selectMmsProjectInfoByProjectId(Long projectId);


    /**
     *更新项目审核状态
     * @param projectPublishUpdatedVo
     */
    int updateProjectInfoByName(ProjectPublishUpdatedVo projectPublishUpdatedVo);

    /**
     * 查询项目信息主表列表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 项目信息主表集合
     */
    public List<MmsProjectInfo> selectMmsProjectInfoList(MmsProjectInfo mmsProjectInfo);

    /**
     * 新增项目信息主表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 结果
     */
    public int insertMmsProjectInfo(MmsProjectInfo mmsProjectInfo);

    /**
     * 修改项目信息主表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 结果
     */
    public int updateMmsProjectInfo(MmsProjectInfo mmsProjectInfo);

    /**
     * 批量删除项目信息主表
     * 
     * @param projectIds 需要删除的项目信息主表主键集合
     * @return 结果
     */
    public int deleteMmsProjectInfoByProjectIds(Long[] projectIds);

    /**
     * 删除项目信息主表信息
     * 
     * @param projectId 项目信息主表主键
     * @return 结果
     */
    public int deleteMmsProjectInfoByProjectId(Long projectId);


    ProjectInfo selectMmsProjectInfoToEs(String projectName);
}
