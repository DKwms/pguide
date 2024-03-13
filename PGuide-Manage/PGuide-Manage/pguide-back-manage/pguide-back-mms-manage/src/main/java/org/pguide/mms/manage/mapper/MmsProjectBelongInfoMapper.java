package org.pguide.mms.manage.mapper;

import java.util.List;
import org.pguide.mms.manage.domain.MmsProjectBelongInfo;

/**
 * 项目从属信息表Mapper接口
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public interface MmsProjectBelongInfoMapper 
{
    /**
     * 查询项目从属信息表
     * 
     * @param belongId 项目从属信息表主键
     * @return 项目从属信息表
     */
    public MmsProjectBelongInfo selectMmsProjectBelongInfoByBelongId(Long belongId);

    /**
     * 查询项目从属信息表列表
     * 
     * @param mmsProjectBelongInfo 项目从属信息表
     * @return 项目从属信息表集合
     */
    public List<MmsProjectBelongInfo> selectMmsProjectBelongInfoList(MmsProjectBelongInfo mmsProjectBelongInfo);

    /**
     * 新增项目从属信息表
     * 
     * @param mmsProjectBelongInfo 项目从属信息表
     * @return 结果
     */
    public int insertMmsProjectBelongInfo(MmsProjectBelongInfo mmsProjectBelongInfo);

    /**
     * 修改项目从属信息表
     * 
     * @param mmsProjectBelongInfo 项目从属信息表
     * @return 结果
     */
    public int updateMmsProjectBelongInfo(MmsProjectBelongInfo mmsProjectBelongInfo);

    /**
     * 删除项目从属信息表
     * 
     * @param belongId 项目从属信息表主键
     * @return 结果
     */
    public int deleteMmsProjectBelongInfoByBelongId(Long belongId);

    /**
     * 批量删除项目从属信息表
     * 
     * @param belongIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsProjectBelongInfoByBelongIds(Long[] belongIds);
}
