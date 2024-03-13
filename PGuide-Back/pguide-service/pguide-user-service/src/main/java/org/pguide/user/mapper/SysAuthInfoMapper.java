package org.pguide.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.user.entity.SysAuthInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author ROG
* @description 针对表【sys_auth_info】的数据库操作Mapper
* @createDate 2024-01-30 16:20:58
* @Entity org.pguide.user.entity.SysAuthInfo
*/
@Mapper
public interface SysAuthInfoMapper extends BaseMapper<SysAuthInfo> {

}




