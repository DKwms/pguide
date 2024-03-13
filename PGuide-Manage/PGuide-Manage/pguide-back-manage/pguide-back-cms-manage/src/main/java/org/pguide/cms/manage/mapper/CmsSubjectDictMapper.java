package org.pguide.cms.manage.mapper;

import java.util.List;
import org.pguide.cms.manage.domain.CmsSubjectDict;

/**
 * 学科字典Mapper接口
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public interface CmsSubjectDictMapper 
{
    /**
     * 查询学科字典
     * 
     * @param subjectId 学科字典主键
     * @return 学科字典
     */
    public CmsSubjectDict selectCmsSubjectDictBySubjectId(Long subjectId);

    /**
     * 查询学科字典列表
     * 
     * @param cmsSubjectDict 学科字典
     * @return 学科字典集合
     */
    public List<CmsSubjectDict> selectCmsSubjectDictList(CmsSubjectDict cmsSubjectDict);

    /**
     * 新增学科字典
     * 
     * @param cmsSubjectDict 学科字典
     * @return 结果
     */
    public int insertCmsSubjectDict(CmsSubjectDict cmsSubjectDict);

    /**
     * 修改学科字典
     * 
     * @param cmsSubjectDict 学科字典
     * @return 结果
     */
    public int updateCmsSubjectDict(CmsSubjectDict cmsSubjectDict);

    /**
     * 删除学科字典
     * 
     * @param subjectId 学科字典主键
     * @return 结果
     */
    public int deleteCmsSubjectDictBySubjectId(Long subjectId);

    /**
     * 批量删除学科字典
     * 
     * @param subjectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCmsSubjectDictBySubjectIds(Long[] subjectIds);
}
