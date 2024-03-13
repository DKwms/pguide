package org.pguide.mms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.mms.manage.mapper.MmsProjectMemberInfoMapper;
import org.pguide.mms.manage.domain.MmsProjectMemberInfo;
import org.pguide.mms.manage.service.IMmsProjectMemberInfoService;

/**
 * 项目成员信息表Service业务层处理
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.MMS)
public class MmsProjectMemberInfoServiceImpl implements IMmsProjectMemberInfoService 
{
    @Autowired
    private MmsProjectMemberInfoMapper mmsProjectMemberInfoMapper;

    /**
     * 查询项目成员信息表
     * 
     * @param projectId 项目成员信息表主键
     * @return 项目成员信息表
     */
    @Override
    public MmsProjectMemberInfo selectMmsProjectMemberInfoByProjectId(Long projectId)
    {
        return mmsProjectMemberInfoMapper.selectMmsProjectMemberInfoByProjectId(projectId);
    }

    /**
     * 查询项目成员信息表列表
     * 
     * @param mmsProjectMemberInfo 项目成员信息表
     * @return 项目成员信息表
     */
    @Override
    public List<MmsProjectMemberInfo> selectMmsProjectMemberInfoList(MmsProjectMemberInfo mmsProjectMemberInfo)
    {
        return mmsProjectMemberInfoMapper.selectMmsProjectMemberInfoList(mmsProjectMemberInfo);
    }

    /**
     * 新增项目成员信息表
     * 
     * @param mmsProjectMemberInfo 项目成员信息表
     * @return 结果
     */
    @Override
    public int insertMmsProjectMemberInfo(MmsProjectMemberInfo mmsProjectMemberInfo)
    {
        return mmsProjectMemberInfoMapper.insertMmsProjectMemberInfo(mmsProjectMemberInfo);
    }

    /**
     * 修改项目成员信息表
     * 
     * @param mmsProjectMemberInfo 项目成员信息表
     * @return 结果
     */
    @Override
    public int updateMmsProjectMemberInfo(MmsProjectMemberInfo mmsProjectMemberInfo)
    {
        return mmsProjectMemberInfoMapper.updateMmsProjectMemberInfo(mmsProjectMemberInfo);
    }

    /**
     * 批量删除项目成员信息表
     * 
     * @param projectIds 需要删除的项目成员信息表主键
     * @return 结果
     */
    @Override
    public int deleteMmsProjectMemberInfoByProjectIds(Long[] projectIds)
    {
        return mmsProjectMemberInfoMapper.deleteMmsProjectMemberInfoByProjectIds(projectIds);
    }

    /**
     * 删除项目成员信息表信息
     * 
     * @param projectId 项目成员信息表主键
     * @return 结果
     */
    @Override
    public int deleteMmsProjectMemberInfoByProjectId(Long projectId)
    {
        return mmsProjectMemberInfoMapper.deleteMmsProjectMemberInfoByProjectId(projectId);
    }
}
