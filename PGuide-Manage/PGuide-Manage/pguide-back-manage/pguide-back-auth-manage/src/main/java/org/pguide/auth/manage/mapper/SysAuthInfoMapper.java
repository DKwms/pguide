package org.pguide.auth.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.auth.manage.entity.SysAuthInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author ROG
* @description 针对表【sys_auth_info】的数据库操作Mapper
* @createDate 2024-01-05 19:09:54
* @Entity org.pguide.auth.manage.entity.SysAuthInfo
*/

@Mapper
public interface SysAuthInfoMapper extends BaseMapper<SysAuthInfo> {
    /**
     * 查询登录权限控制
     *
     * @param sysId 登录权限控制主键
     * @return 登录权限控制
     */
    public SysAuthInfo selectSysAuthInfoBySysId(Long sysId);

    /**
     * 查询登录权限控制列表
     *
     * @param sysAuthInfo 登录权限控制
     * @return 登录权限控制集合
     */
    public List<SysAuthInfo> selectSysAuthInfoList(SysAuthInfo sysAuthInfo);

    /**
     * 新增登录权限控制
     *
     * @param sysAuthInfo 登录权限控制
     * @return 结果
     */
    public int insertSysAuthInfo(SysAuthInfo sysAuthInfo);

    /**
     * 修改登录权限控制
     *
     * @param sysAuthInfo 登录权限控制
     * @return 结果
     */
    public int updateSysAuthInfo(SysAuthInfo sysAuthInfo);

    /**
     * 删除登录权限控制
     *
     * @param sysId 登录权限控制主键
     * @return 结果
     */
    public int deleteSysAuthInfoBySysId(Long sysId);

    /**
     * 批量删除登录权限控制
     *
     * @param sysIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysAuthInfoBySysIds(Long[] sysIds);
}




