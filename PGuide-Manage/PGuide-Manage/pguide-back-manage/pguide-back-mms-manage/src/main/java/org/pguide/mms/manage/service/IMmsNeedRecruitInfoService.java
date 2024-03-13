package org.pguide.mms.manage.service;

import java.util.List;
import org.pguide.mms.manage.domain.MmsNeedRecruitInfo;

/**
 * 项目需求招募信息Service接口
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public interface IMmsNeedRecruitInfoService 
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
     * 批量删除项目需求招募信息
     * 
     * @param recruitIds 需要删除的项目需求招募信息主键集合
     * @return 结果
     */
    public int deleteMmsNeedRecruitInfoByRecruitIds(Long[] recruitIds);

    /**
     * 删除项目需求招募信息信息
     * 
     * @param recruitId 项目需求招募信息主键
     * @return 结果
     */
    public int deleteMmsNeedRecruitInfoByRecruitId(Long recruitId);
}
