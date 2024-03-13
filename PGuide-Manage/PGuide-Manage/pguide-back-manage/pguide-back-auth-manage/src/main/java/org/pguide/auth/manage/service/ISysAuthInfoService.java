package org.pguide.auth.manage.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.pguide.auth.manage.entity.SysAuthInfo;

import java.util.List;

/**
 * 登录权限控制Service接口
 * 
 * @author DKwms
 * @date 2024-01-20
 */
public interface ISysAuthInfoService extends IService<SysAuthInfo>
{
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
     * 批量删除登录权限控制
     * 
     * @param sysIds 需要删除的登录权限控制主键集合
     * @return 结果
     */
    public int deleteSysAuthInfoBySysIds(Long[] sysIds);

    /**
     * 删除登录权限控制信息
     * 
     * @param sysId 登录权限控制主键
     * @return 结果
     */
    public int deleteSysAuthInfoBySysId(Long sysId);
}
