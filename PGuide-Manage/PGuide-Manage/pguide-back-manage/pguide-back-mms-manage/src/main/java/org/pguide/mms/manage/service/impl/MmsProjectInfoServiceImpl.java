package org.pguide.mms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.pguide.mms.manage.controller.publish.es.domain.dto.ProjectInfo;
import org.pguide.mms.manage.controller.publish.vo.ProjectPublishUpdatedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.mms.manage.mapper.MmsProjectInfoMapper;
import org.pguide.mms.manage.domain.MmsProjectInfo;
import org.pguide.mms.manage.service.IMmsProjectInfoService;

/**
 * 项目信息主表Service业务层处理
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.MMS)
public class MmsProjectInfoServiceImpl implements IMmsProjectInfoService 
{
    @Autowired
    private MmsProjectInfoMapper mmsProjectInfoMapper;

    /**
     * 查询项目信息主表
     * 
     * @param projectId 项目信息主表主键
     * @return 项目信息主表
     */
    @Override
    public MmsProjectInfo selectMmsProjectInfoByProjectId(Long projectId)
    {
        return mmsProjectInfoMapper.selectMmsProjectInfoByProjectId(projectId);
    }

    /**
     * 查询项目信息主表列表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 项目信息主表
     */
    @Override
    public List<MmsProjectInfo> selectMmsProjectInfoList(MmsProjectInfo mmsProjectInfo)
    {
        return mmsProjectInfoMapper.selectMmsProjectInfoList(mmsProjectInfo);
    }

    /**
     * 新增项目信息主表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 结果
     */
    @Override
    public int insertMmsProjectInfo(MmsProjectInfo mmsProjectInfo)
    {
        return mmsProjectInfoMapper.insertMmsProjectInfo(mmsProjectInfo);
    }

    /**
     * 修改项目信息主表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 结果
     */
    @Override
    public int updateMmsProjectInfo(MmsProjectInfo mmsProjectInfo)
    {
        return mmsProjectInfoMapper.updateMmsProjectInfo(mmsProjectInfo);
    }

    /**
     * 批量删除项目信息主表
     * 
     * @param projectIds 需要删除的项目信息主表主键
     * @return 结果
     */
    @Override
    public int deleteMmsProjectInfoByProjectIds(Long[] projectIds)
    {
        return mmsProjectInfoMapper.deleteMmsProjectInfoByProjectIds(projectIds);
    }

    /**
     * 删除项目信息主表信息
     * 
     * @param projectId 项目信息主表主键
     * @return 结果
     */
    @Override
    public int deleteMmsProjectInfoByProjectId(Long projectId)
    {
        return mmsProjectInfoMapper.deleteMmsProjectInfoByProjectId(projectId);
    }

    @Override
    public ProjectInfo selectMmsProjectInfoToEs(String projectName) {

        return mmsProjectInfoMapper.selectMmsProjectInfoToESByProjectName(projectName);
    }

    public int updateProjectInfoByName(ProjectPublishUpdatedVo projectPublishUpdatedVo) {

        return mmsProjectInfoMapper.updateMmsProjectInfoStatus(projectPublishUpdatedVo);
    }
}
