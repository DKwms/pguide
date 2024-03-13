package org.pguide.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.user.entity.ThirdPartyLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.annotation.ManagedBean;

/**
* @author ROG
* @description 针对表【third_party_login】的数据库操作Mapper
* @createDate 2024-01-30 16:20:58
* @Entity org.pguide.user.entity.ThirdPartyLogin
*/
@Mapper
public interface ThirdPartyLoginMapper extends BaseMapper<ThirdPartyLogin> {

}




