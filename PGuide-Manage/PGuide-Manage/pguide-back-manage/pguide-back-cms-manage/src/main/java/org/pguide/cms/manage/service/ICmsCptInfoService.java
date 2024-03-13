package org.pguide.cms.manage.service;

import java.util.List;
import org.pguide.cms.manage.domain.CmsCptInfo;

/**
 * 比赛信息Service接口
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public interface ICmsCptInfoService 
{
    /**
     * 查询比赛信息
     * 
     * @param cptId 比赛信息主键
     * @return 比赛信息
     */
    public CmsCptInfo selectCmsCptInfoByCptId(Long cptId);

    /**
     * 查询比赛信息列表
     * 
     * @param cmsCptInfo 比赛信息
     * @return 比赛信息集合
     */
    public List<CmsCptInfo> selectCmsCptInfoList(CmsCptInfo cmsCptInfo);

    /**
     * 新增比赛信息
     * 
     * @param cmsCptInfo 比赛信息
     * @return 结果
     */
    public int insertCmsCptInfo(CmsCptInfo cmsCptInfo);

    /**
     * 修改比赛信息
     * 
     * @param cmsCptInfo 比赛信息
     * @return 结果
     */
    public int updateCmsCptInfo(CmsCptInfo cmsCptInfo);

    /**
     * 批量删除比赛信息
     * 
     * @param cptIds 需要删除的比赛信息主键集合
     * @return 结果
     */
    public int deleteCmsCptInfoByCptIds(Long[] cptIds);

    /**
     * 删除比赛信息信息
     * 
     * @param cptId 比赛信息主键
     * @return 结果
     */
    public int deleteCmsCptInfoByCptId(Long cptId);
}
