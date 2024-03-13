package org.pguide.competition.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.competition.manage.entity.CmsOrgDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.annotation.ManagedBean;

/**
* @author ROG
* @description 针对表【cms_org_dict】的数据库操作Mapper
* @createDate 2024-01-16 16:36:51
* @Entity org.pguide.competition.manage.entity.CmsOrgDict
*/
@Mapper
public interface CmsOrgDictMapper extends BaseMapper<CmsOrgDict> {

}




