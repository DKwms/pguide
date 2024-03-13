package org.pguide.mms.manage.mapper;

import java.util.List;
import org.pguide.mms.manage.domain.MmsNeedTypeDict;

/**
 * 需求类型字典表Mapper接口
 * 
 * @author dkwms
 * @date 2024-01-16
 */
public interface MmsNeedTypeDictMapper 
{
    /**
     * 查询需求类型字典表
     * 
     * @param needTypeId 需求类型字典表主键
     * @return 需求类型字典表
     */
    public MmsNeedTypeDict selectMmsNeedTypeDictByNeedTypeId(Long needTypeId);

    /**
     * 查询需求类型字典表列表
     * 
     * @param mmsNeedTypeDict 需求类型字典表
     * @return 需求类型字典表集合
     */
    public List<MmsNeedTypeDict> selectMmsNeedTypeDictList(MmsNeedTypeDict mmsNeedTypeDict);

    /**
     * 新增需求类型字典表
     * 
     * @param mmsNeedTypeDict 需求类型字典表
     * @return 结果
     */
    public int insertMmsNeedTypeDict(MmsNeedTypeDict mmsNeedTypeDict);

    /**
     * 修改需求类型字典表
     * 
     * @param mmsNeedTypeDict 需求类型字典表
     * @return 结果
     */
    public int updateMmsNeedTypeDict(MmsNeedTypeDict mmsNeedTypeDict);

    /**
     * 删除需求类型字典表
     * 
     * @param needTypeId 需求类型字典表主键
     * @return 结果
     */
    public int deleteMmsNeedTypeDictByNeedTypeId(Long needTypeId);

    /**
     * 批量删除需求类型字典表
     * 
     * @param needTypeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsNeedTypeDictByNeedTypeIds(Long[] needTypeIds);
}
