package org.pguide.user.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.pguide.user.manage.entity.ThirdPartyLogin;
import org.pguide.user.manage.service.ThirdPartyLoginService;
import org.pguide.user.manage.mapper.ThirdPartyLoginMapper;
import org.springframework.stereotype.Service;

/**
* @author ROG
* @description 针对表【third_party_login】的数据库操作Service实现
* @createDate 2023-12-30 21:07:35
*/
@Service
@DataSource(value = DataSourceType.USER)
public class ThirdPartyLoginServiceImpl extends ServiceImpl<ThirdPartyLoginMapper, ThirdPartyLogin>
    implements ThirdPartyLoginService{



}




