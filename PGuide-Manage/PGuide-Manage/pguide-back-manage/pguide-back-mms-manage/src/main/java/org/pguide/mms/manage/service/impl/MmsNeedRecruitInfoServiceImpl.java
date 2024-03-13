package org.pguide.mms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.mms.manage.mapper.MmsNeedRecruitInfoMapper;
import org.pguide.mms.manage.domain.MmsNeedRecruitInfo;
import org.pguide.mms.manage.service.IMmsNeedRecruitInfoService;

/**
 * 项目需求招募信息Service业务层处理
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.MMS)
public class MmsNeedRecruitInfoServiceImpl implements IMmsNeedRecruitInfoService
{
    @Autowired
    private MmsNeedRecruitInfoMapper mmsNeedRecruitInfoMapper;

    /**
     * 查询项目需求招募信息
     * 
     * @param recruitId 项目需求招募信息主键
     * @return 项目需求招募信息
     */
    @Override
    public MmsNeedRecruitInfo selectMmsNeedRecruitInfoByRecruitId(Long recruitId)
    {
        return mmsNeedRecruitInfoMapper.selectMmsNeedRecruitInfoByRecruitId(recruitId);
    }

    /**
     * 查询项目需求招募信息列表
     * 
     * @param mmsNeedRecruitInfo 项目需求招募信息
     * @return 项目需求招募信息
     */
    @Override
    public List<MmsNeedRecruitInfo> selectMmsNeedRecruitInfoList(MmsNeedRecruitInfo mmsNeedRecruitInfo)
    {
        return mmsNeedRecruitInfoMapper.selectMmsNeedRecruitInfoList(mmsNeedRecruitInfo);
    }

    /**
     * 新增项目需求招募信息
     * 
     * @param mmsNeedRecruitInfo 项目需求招募信息
     * @return 结果
     */
    @Override
    public int insertMmsNeedRecruitInfo(MmsNeedRecruitInfo mmsNeedRecruitInfo)
    {
        return mmsNeedRecruitInfoMapper.insertMmsNeedRecruitInfo(mmsNeedRecruitInfo);
    }

    /**
     * 修改项目需求招募信息
     * 
     * @param mmsNeedRecruitInfo 项目需求招募信息
     * @return 结果
     */
    @Override
    public int updateMmsNeedRecruitInfo(MmsNeedRecruitInfo mmsNeedRecruitInfo)
    {
        return mmsNeedRecruitInfoMapper.updateMmsNeedRecruitInfo(mmsNeedRecruitInfo);
    }

    /**
     * 批量删除项目需求招募信息
     * 
     * @param recruitIds 需要删除的项目需求招募信息主键
     * @return 结果
     */
    @Override
    public int deleteMmsNeedRecruitInfoByRecruitIds(Long[] recruitIds)
    {
        return mmsNeedRecruitInfoMapper.deleteMmsNeedRecruitInfoByRecruitIds(recruitIds);
    }

    /**
     * 删除项目需求招募信息信息
     * 
     * @param recruitId 项目需求招募信息主键
     * @return 结果
     */
    @Override
    public int deleteMmsNeedRecruitInfoByRecruitId(Long recruitId)
    {
        return mmsNeedRecruitInfoMapper.deleteMmsNeedRecruitInfoByRecruitId(recruitId);
    }
}
