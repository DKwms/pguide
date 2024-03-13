package org.pguide.mms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.mms.manage.mapper.MmsMemberTypeDictMapper;
import org.pguide.mms.manage.domain.MmsMemberTypeDict;
import org.pguide.mms.manage.service.IMmsMemberTypeDictService;

/**
 * 成员属性字典表Service业务层处理
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@DataSource(value = DataSourceType.MMS)
@Service
public class MmsMemberTypeDictServiceImpl implements IMmsMemberTypeDictService
{
    @Autowired
    private MmsMemberTypeDictMapper mmsMemberTypeDictMapper;

    /**
     * 查询成员属性字典表
     * 
     * @param memberTypeId 成员属性字典表主键
     * @return 成员属性字典表
     */
    @Override
    public MmsMemberTypeDict selectMmsMemberTypeDictByMemberTypeId(Long memberTypeId)
    {
        return mmsMemberTypeDictMapper.selectMmsMemberTypeDictByMemberTypeId(memberTypeId);
    }

    /**
     * 查询成员属性字典表列表
     * 
     * @param mmsMemberTypeDict 成员属性字典表
     * @return 成员属性字典表
     */
    @Override
    public List<MmsMemberTypeDict> selectMmsMemberTypeDictList(MmsMemberTypeDict mmsMemberTypeDict)
    {
        return mmsMemberTypeDictMapper.selectMmsMemberTypeDictList(mmsMemberTypeDict);
    }

    /**
     * 新增成员属性字典表
     * 
     * @param mmsMemberTypeDict 成员属性字典表
     * @return 结果
     */
    @Override
    public int insertMmsMemberTypeDict(MmsMemberTypeDict mmsMemberTypeDict)
    {
        return mmsMemberTypeDictMapper.insertMmsMemberTypeDict(mmsMemberTypeDict);
    }

    /**
     * 修改成员属性字典表
     * 
     * @param mmsMemberTypeDict 成员属性字典表
     * @return 结果
     */
    @Override
    public int updateMmsMemberTypeDict(MmsMemberTypeDict mmsMemberTypeDict)
    {
        return mmsMemberTypeDictMapper.updateMmsMemberTypeDict(mmsMemberTypeDict);
    }

    /**
     * 批量删除成员属性字典表
     * 
     * @param memberTypeIds 需要删除的成员属性字典表主键
     * @return 结果
     */
    @Override
    public int deleteMmsMemberTypeDictByMemberTypeIds(Long[] memberTypeIds)
    {
        return mmsMemberTypeDictMapper.deleteMmsMemberTypeDictByMemberTypeIds(memberTypeIds);
    }

    /**
     * 删除成员属性字典表信息
     * 
     * @param memberTypeId 成员属性字典表主键
     * @return 结果
     */
    @Override
    public int deleteMmsMemberTypeDictByMemberTypeId(Long memberTypeId)
    {
        return mmsMemberTypeDictMapper.deleteMmsMemberTypeDictByMemberTypeId(memberTypeId);
    }
}
