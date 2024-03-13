package org.pguide.cms.manage.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.cms.manage.mapper.CmsOrgDictMapper;
import org.pguide.cms.manage.domain.CmsOrgDict;
import org.pguide.cms.manage.service.ICmsOrgDictService;

/**
 * 组织字典Service业务层处理
 * 
 * @author DKwms
 * @date 2024-01-16
 */
@Service
@DataSource(value = DataSourceType.CMS)
public class CmsOrgDictServiceImpl implements ICmsOrgDictService 
{
    @Autowired
    private CmsOrgDictMapper cmsOrgDictMapper;

    /**
     * 查询组织字典
     * 
     * @param orgId 组织字典主键
     * @return 组织字典
     */
    @Override
    public CmsOrgDict selectCmsOrgDictByOrgId(Long orgId)
    {
        return cmsOrgDictMapper.selectCmsOrgDictByOrgId(orgId);
    }

    /**
     * 查询组织字典列表
     * 
     * @param cmsOrgDict 组织字典
     * @return 组织字典
     */
    @Override
    public List<CmsOrgDict> selectCmsOrgDictList(CmsOrgDict cmsOrgDict)
    {
        return cmsOrgDictMapper.selectCmsOrgDictList(cmsOrgDict);
    }

    /**
     * 新增组织字典
     * 
     * @param cmsOrgDict 组织字典
     * @return 结果
     */
    @Override
    public int insertCmsOrgDict(CmsOrgDict cmsOrgDict)
    {
        return cmsOrgDictMapper.insertCmsOrgDict(cmsOrgDict);
    }

    /**
     * 修改组织字典
     * 
     * @param cmsOrgDict 组织字典
     * @return 结果
     */
    @Override
    public int updateCmsOrgDict(CmsOrgDict cmsOrgDict)
    {
        return cmsOrgDictMapper.updateCmsOrgDict(cmsOrgDict);
    }

    /**
     * 批量删除组织字典
     * 
     * @param orgIds 需要删除的组织字典主键
     * @return 结果
     */
    @Override
    public int deleteCmsOrgDictByOrgIds(Long[] orgIds)
    {
        return cmsOrgDictMapper.deleteCmsOrgDictByOrgIds(orgIds);
    }

    /**
     * 删除组织字典信息
     * 
     * @param orgId 组织字典主键
     * @return 结果
     */
    @Override
    public int deleteCmsOrgDictByOrgId(Long orgId)
    {
        return cmsOrgDictMapper.deleteCmsOrgDictByOrgId(orgId);
    }
}
