package org.pguide.cms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.cms.manage.mapper.CmsCptInfoMapper;
import org.pguide.cms.manage.domain.CmsCptInfo;
import org.pguide.cms.manage.service.ICmsCptInfoService;

/**
 * 比赛信息Service业务层处理
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.CMS)
public class CmsCptInfoServiceImpl implements ICmsCptInfoService 
{
    @Autowired
    private CmsCptInfoMapper cmsCptInfoMapper;

    /**
     * 查询比赛信息
     * 
     * @param cptId 比赛信息主键
     * @return 比赛信息
     */
    @Override
    public CmsCptInfo selectCmsCptInfoByCptId(Long cptId)
    {
        return cmsCptInfoMapper.selectCmsCptInfoByCptId(cptId);
    }

    /**
     * 查询比赛信息列表
     * 
     * @param cmsCptInfo 比赛信息
     * @return 比赛信息
     */
    @Override
    public List<CmsCptInfo> selectCmsCptInfoList(CmsCptInfo cmsCptInfo)
    {
        return cmsCptInfoMapper.selectCmsCptInfoList(cmsCptInfo);
    }

    /**
     * 新增比赛信息
     * 
     * @param cmsCptInfo 比赛信息
     * @return 结果
     */
    @Override
    public int insertCmsCptInfo(CmsCptInfo cmsCptInfo)
    {
        return cmsCptInfoMapper.insertCmsCptInfo(cmsCptInfo);
    }

    /**
     * 修改比赛信息
     * 
     * @param cmsCptInfo 比赛信息
     * @return 结果
     */
    @Override
    public int updateCmsCptInfo(CmsCptInfo cmsCptInfo)
    {
        return cmsCptInfoMapper.updateCmsCptInfo(cmsCptInfo);
    }

    /**
     * 批量删除比赛信息
     * 
     * @param cptIds 需要删除的比赛信息主键
     * @return 结果
     */
    @Override
    public int deleteCmsCptInfoByCptIds(Long[] cptIds)
    {
        return cmsCptInfoMapper.deleteCmsCptInfoByCptIds(cptIds);
    }

    /**
     * 删除比赛信息信息
     * 
     * @param cptId 比赛信息主键
     * @return 结果
     */
    @Override
    public int deleteCmsCptInfoByCptId(Long cptId)
    {
        return cmsCptInfoMapper.deleteCmsCptInfoByCptId(cptId);
    }
}
