package org.pguide.cms.manage.mapper;

import java.util.List;
import org.pguide.cms.manage.domain.CmsOrgDict;

/**
 * 组织字典Mapper接口
 * 
 * @author DKwms
 * @date 2024-01-16
 */
public interface CmsOrgDictMapper 
{
    /**
     * 查询组织字典
     * 
     * @param orgId 组织字典主键
     * @return 组织字典
     */
    public CmsOrgDict selectCmsOrgDictByOrgId(Long orgId);

    /**
     * 查询组织字典列表
     * 
     * @param cmsOrgDict 组织字典
     * @return 组织字典集合
     */
    public List<CmsOrgDict> selectCmsOrgDictList(CmsOrgDict cmsOrgDict);

    /**
     * 新增组织字典
     * 
     * @param cmsOrgDict 组织字典
     * @return 结果
     */
    public int insertCmsOrgDict(CmsOrgDict cmsOrgDict);

    /**
     * 修改组织字典
     * 
     * @param cmsOrgDict 组织字典
     * @return 结果
     */
    public int updateCmsOrgDict(CmsOrgDict cmsOrgDict);

    /**
     * 删除组织字典
     * 
     * @param orgId 组织字典主键
     * @return 结果
     */
    public int deleteCmsOrgDictByOrgId(Long orgId);

    /**
     * 批量删除组织字典
     * 
     * @param orgIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCmsOrgDictByOrgIds(Long[] orgIds);
}
