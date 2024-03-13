package org.pguide.cms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.cms.manage.mapper.CmsSubjectDictMapper;
import org.pguide.cms.manage.domain.CmsSubjectDict;
import org.pguide.cms.manage.service.ICmsSubjectDictService;

/**
 * 学科字典Service业务层处理
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.CMS)
public class CmsSubjectDictServiceImpl implements ICmsSubjectDictService 
{
    @Autowired
    private CmsSubjectDictMapper cmsSubjectDictMapper;

    /**
     * 查询学科字典
     * 
     * @param subjectId 学科字典主键
     * @return 学科字典
     */
    @Override
    public CmsSubjectDict selectCmsSubjectDictBySubjectId(Long subjectId)
    {
        return cmsSubjectDictMapper.selectCmsSubjectDictBySubjectId(subjectId);
    }

    /**
     * 查询学科字典列表
     * 
     * @param cmsSubjectDict 学科字典
     * @return 学科字典
     */
    @Override
    public List<CmsSubjectDict> selectCmsSubjectDictList(CmsSubjectDict cmsSubjectDict)
    {
        return cmsSubjectDictMapper.selectCmsSubjectDictList(cmsSubjectDict);
    }

    /**
     * 新增学科字典
     * 
     * @param cmsSubjectDict 学科字典
     * @return 结果
     */
    @Override
    public int insertCmsSubjectDict(CmsSubjectDict cmsSubjectDict)
    {
        return cmsSubjectDictMapper.insertCmsSubjectDict(cmsSubjectDict);
    }

    /**
     * 修改学科字典
     * 
     * @param cmsSubjectDict 学科字典
     * @return 结果
     */
    @Override
    public int updateCmsSubjectDict(CmsSubjectDict cmsSubjectDict)
    {
        return cmsSubjectDictMapper.updateCmsSubjectDict(cmsSubjectDict);
    }

    /**
     * 批量删除学科字典
     * 
     * @param subjectIds 需要删除的学科字典主键
     * @return 结果
     */
    @Override
    public int deleteCmsSubjectDictBySubjectIds(Long[] subjectIds)
    {
        return cmsSubjectDictMapper.deleteCmsSubjectDictBySubjectIds(subjectIds);
    }

    /**
     * 删除学科字典信息
     * 
     * @param subjectId 学科字典主键
     * @return 结果
     */
    @Override
    public int deleteCmsSubjectDictBySubjectId(Long subjectId)
    {
        return cmsSubjectDictMapper.deleteCmsSubjectDictBySubjectId(subjectId);
    }
}
