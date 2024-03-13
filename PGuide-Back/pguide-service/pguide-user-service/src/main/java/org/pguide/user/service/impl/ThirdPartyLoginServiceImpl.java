package org.pguide.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.pguide.user.entity.ThirdPartyLogin;
import org.pguide.user.service.ThirdPartyLoginService;
import org.pguide.user.mapper.ThirdPartyLoginMapper;
import org.springframework.stereotype.Service;

/**
* @author ROG
* @description 针对表【third_party_login】的数据库操作Service实现
* @createDate 2024-01-30 16:20:58
*/
@Service
public class ThirdPartyLoginServiceImpl extends ServiceImpl<ThirdPartyLoginMapper, ThirdPartyLogin>
    implements ThirdPartyLoginService{

}




