package org.pguide.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.pguide.demo.entity.SysUser;
import org.pguide.demo.service.SysUserService;
import org.pguide.demo.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author User
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2023-10-12 13:31:17
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




