package org.pguide.user.manage.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.pguide.user.manage.entity.ThirdPartyLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author ROG
* @description 针对表【third_party_login】的数据库操作Mapper
* @createDate 2023-12-30 21:07:35
* @Entity org.pguide.user.manage.entity.ThirdPartyLogin
*/

@DataSource(value = DataSourceType.USER)
public interface ThirdPartyLoginMapper extends BaseMapper<ThirdPartyLogin> {

}




