package org.pguide.mms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.mms.manage.mapper.MmsProjectBelongInfoMapper;
import org.pguide.mms.manage.domain.MmsProjectBelongInfo;
import org.pguide.mms.manage.service.IMmsProjectBelongInfoService;

/**
 * 项目从属信息表Service业务层处理
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.MMS)
public class MmsProjectBelongInfoServiceImpl implements IMmsProjectBelongInfoService 
{
    @Autowired
    private MmsProjectBelongInfoMapper mmsProjectBelongInfoMapper;

    /**
     * 查询项目从属信息表
     * 
     * @param belongId 项目从属信息表主键
     * @return 项目从属信息表
     */
    @Override
    public MmsProjectBelongInfo selectMmsProjectBelongInfoByBelongId(Long belongId)
    {
        return mmsProjectBelongInfoMapper.selectMmsProjectBelongInfoByBelongId(belongId);
    }

    /**
     * 查询项目从属信息表列表
     * 
     * @param mmsProjectBelongInfo 项目从属信息表
     * @return 项目从属信息表
     */
    @Override
    public List<MmsProjectBelongInfo> selectMmsProjectBelongInfoList(MmsProjectBelongInfo mmsProjectBelongInfo)
    {
        return mmsProjectBelongInfoMapper.selectMmsProjectBelongInfoList(mmsProjectBelongInfo);
    }

    /**
     * 新增项目从属信息表
     * 
     * @param mmsProjectBelongInfo 项目从属信息表
     * @return 结果
     */
    @Override
    public int insertMmsProjectBelongInfo(MmsProjectBelongInfo mmsProjectBelongInfo)
    {
        return mmsProjectBelongInfoMapper.insertMmsProjectBelongInfo(mmsProjectBelongInfo);
    }

    /**
     * 修改项目从属信息表
     * 
     * @param mmsProjectBelongInfo 项目从属信息表
     * @return 结果
     */
    @Override
    public int updateMmsProjectBelongInfo(MmsProjectBelongInfo mmsProjectBelongInfo)
    {
        return mmsProjectBelongInfoMapper.updateMmsProjectBelongInfo(mmsProjectBelongInfo);
    }

    /**
     * 批量删除项目从属信息表
     * 
     * @param belongIds 需要删除的项目从属信息表主键
     * @return 结果
     */
    @Override
    public int deleteMmsProjectBelongInfoByBelongIds(Long[] belongIds)
    {
        return mmsProjectBelongInfoMapper.deleteMmsProjectBelongInfoByBelongIds(belongIds);
    }

    /**
     * 删除项目从属信息表信息
     * 
     * @param belongId 项目从属信息表主键
     * @return 结果
     */
    @Override
    public int deleteMmsProjectBelongInfoByBelongId(Long belongId)
    {
        return mmsProjectBelongInfoMapper.deleteMmsProjectBelongInfoByBelongId(belongId);
    }
}
