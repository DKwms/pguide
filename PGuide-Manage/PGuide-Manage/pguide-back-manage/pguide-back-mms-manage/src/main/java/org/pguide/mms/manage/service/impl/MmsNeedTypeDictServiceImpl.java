package org.pguide.mms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.mms.manage.mapper.MmsNeedTypeDictMapper;
import org.pguide.mms.manage.domain.MmsNeedTypeDict;
import org.pguide.mms.manage.service.IMmsNeedTypeDictService;

/**
 * 需求类型字典表Service业务层处理
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.MMS)
public class MmsNeedTypeDictServiceImpl implements IMmsNeedTypeDictService 
{
    @Autowired
    private MmsNeedTypeDictMapper mmsNeedTypeDictMapper;

    /**
     * 查询需求类型字典表
     * 
     * @param needTypeId 需求类型字典表主键
     * @return 需求类型字典表
     */
    @Override
    public MmsNeedTypeDict selectMmsNeedTypeDictByNeedTypeId(Long needTypeId)
    {
        return mmsNeedTypeDictMapper.selectMmsNeedTypeDictByNeedTypeId(needTypeId);
    }

    /**
     * 查询需求类型字典表列表
     * 
     * @param mmsNeedTypeDict 需求类型字典表
     * @return 需求类型字典表
     */
    @Override
    public List<MmsNeedTypeDict> selectMmsNeedTypeDictList(MmsNeedTypeDict mmsNeedTypeDict)
    {
        return mmsNeedTypeDictMapper.selectMmsNeedTypeDictList(mmsNeedTypeDict);
    }

    /**
     * 新增需求类型字典表
     * 
     * @param mmsNeedTypeDict 需求类型字典表
     * @return 结果
     */
    @Override
    public int insertMmsNeedTypeDict(MmsNeedTypeDict mmsNeedTypeDict)
    {
        return mmsNeedTypeDictMapper.insertMmsNeedTypeDict(mmsNeedTypeDict);
    }

    /**
     * 修改需求类型字典表
     * 
     * @param mmsNeedTypeDict 需求类型字典表
     * @return 结果
     */
    @Override
    public int updateMmsNeedTypeDict(MmsNeedTypeDict mmsNeedTypeDict)
    {
        return mmsNeedTypeDictMapper.updateMmsNeedTypeDict(mmsNeedTypeDict);
    }

    /**
     * 批量删除需求类型字典表
     * 
     * @param needTypeIds 需要删除的需求类型字典表主键
     * @return 结果
     */
    @Override
    public int deleteMmsNeedTypeDictByNeedTypeIds(Long[] needTypeIds)
    {
        return mmsNeedTypeDictMapper.deleteMmsNeedTypeDictByNeedTypeIds(needTypeIds);
    }

    /**
     * 删除需求类型字典表信息
     * 
     * @param needTypeId 需求类型字典表主键
     * @return 结果
     */
    @Override
    public int deleteMmsNeedTypeDictByNeedTypeId(Long needTypeId)
    {
        return mmsNeedTypeDictMapper.deleteMmsNeedTypeDictByNeedTypeId(needTypeId);
    }
}
