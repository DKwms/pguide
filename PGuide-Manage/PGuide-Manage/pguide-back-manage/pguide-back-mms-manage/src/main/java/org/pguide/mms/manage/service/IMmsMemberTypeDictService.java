package org.pguide.mms.manage.service;

import java.util.List;
import org.pguide.mms.manage.domain.MmsMemberTypeDict;

/**
 * 成员属性字典表Service接口
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public interface IMmsMemberTypeDictService 
{
    /**
     * 查询成员属性字典表
     * 
     * @param memberTypeId 成员属性字典表主键
     * @return 成员属性字典表
     */
    public MmsMemberTypeDict selectMmsMemberTypeDictByMemberTypeId(Long memberTypeId);

    /**
     * 查询成员属性字典表列表
     * 
     * @param mmsMemberTypeDict 成员属性字典表
     * @return 成员属性字典表集合
     */
    public List<MmsMemberTypeDict> selectMmsMemberTypeDictList(MmsMemberTypeDict mmsMemberTypeDict);

    /**
     * 新增成员属性字典表
     * 
     * @param mmsMemberTypeDict 成员属性字典表
     * @return 结果
     */
    public int insertMmsMemberTypeDict(MmsMemberTypeDict mmsMemberTypeDict);

    /**
     * 修改成员属性字典表
     * 
     * @param mmsMemberTypeDict 成员属性字典表
     * @return 结果
     */
    public int updateMmsMemberTypeDict(MmsMemberTypeDict mmsMemberTypeDict);

    /**
     * 批量删除成员属性字典表
     * 
     * @param memberTypeIds 需要删除的成员属性字典表主键集合
     * @return 结果
     */
    public int deleteMmsMemberTypeDictByMemberTypeIds(Long[] memberTypeIds);

    /**
     * 删除成员属性字典表信息
     * 
     * @param memberTypeId 成员属性字典表主键
     * @return 结果
     */
    public int deleteMmsMemberTypeDictByMemberTypeId(Long memberTypeId);
}
