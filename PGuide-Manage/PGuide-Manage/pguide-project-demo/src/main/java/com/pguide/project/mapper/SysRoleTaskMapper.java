package com.pguide.project.mapper;

import com.pguide.project.domain.SysRoleTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
* @author ROG
* @description 针对表【sys_role_task】的数据库操作Mapper
* @createDate 2023-11-15 12:12:30
* @Entity com.pguide.project.domain.SysRoleTask
*/
@DataSource(value = DataSourceType.MASTER)
public interface SysRoleTaskMapper extends BaseMapper<SysRoleTask> {

}




