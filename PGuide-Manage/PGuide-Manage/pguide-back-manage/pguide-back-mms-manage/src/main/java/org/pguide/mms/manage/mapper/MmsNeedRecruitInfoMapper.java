package org.pguide.mms.manage.mapper;

import java.util.List;
import org.pguide.mms.manage.domain.MmsNeedRecruitInfo;

/**
 * 项目需求招募信息Mapper接口
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public interface MmsNeedRecruitInfoMapper 
{
    /**
     * 查询项目需求招募信息
     * 
     * @param recruitId 项目需求招募信息主键
     * @return 项目需求招募信息
     */
    public MmsNeedRecruitInfo selectMmsNeedRecruitInfoByRecruitId(Long recruitId);

    /**
     * 查询项目需求招募信息列表
     * 
     * @param mmsNeedRecruitInfo 项目需求招募信息
     * @return 项目需求招募信息集合
     */
    public List<MmsNeedRecruitInfo> selectMmsNeedRecruitInfoList(MmsNeedRecruitInfo mmsNeedRecruitInfo);

    /**
     * 新增项目需求招募信息
     * 
     * @param mmsNeedRecruitInfo 项目需求招募信息
     * @return 结果
     */
    public int insertMmsNeedRecruitInfo(MmsNeedRecruitInfo mmsNeedRecruitInfo);

    /**
     * 修改项目需求招募信息
     * 
     * @param mmsNeedRecruitInfo 项目需求招募信息
     * @return 结果
     */
    public int updateMmsNeedRecruitInfo(MmsNeedRecruitInfo mmsNeedRecruitInfo);

    /**
     * 删除项目需求招募信息
     * 
     * @param recruitId 项目需求招募信息主键
     * @return 结果
     */
    public int deleteMmsNeedRecruitInfoByRecruitId(Long recruitId);

    /**
     * 批量删除项目需求招募信息
     * 
     * @param recruitIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsNeedRecruitInfoByRecruitIds(Long[] recruitIds);
}
