package org.pguide.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.demo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author User
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2023-10-12 13:31:17
* @Entity org.pguide.demo.entity.SysUser
*/

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}




