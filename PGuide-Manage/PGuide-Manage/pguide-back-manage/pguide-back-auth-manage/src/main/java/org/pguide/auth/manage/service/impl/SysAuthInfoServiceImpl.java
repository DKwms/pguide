package org.pguide.auth.manage.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.pguide.auth.manage.entity.SysAuthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pguide.auth.manage.mapper.SysAuthInfoMapper;

import org.pguide.auth.manage.service.ISysAuthInfoService;

/**
 * 登录权限控制Service业务层处理
 * 
 * @author DKwms
 * @date 2024-01-20
 */
@Service
public class SysAuthInfoServiceImpl extends ServiceImpl<SysAuthInfoMapper, SysAuthInfo> implements ISysAuthInfoService
{
    @Autowired
    private SysAuthInfoMapper sysAuthInfoMapper;

    /**
     * 查询登录权限控制
     * 
     * @param sysId 登录权限控制主键
     * @return 登录权限控制
     */
    @Override
    public SysAuthInfo selectSysAuthInfoBySysId(Long sysId)
    {
        return sysAuthInfoMapper.selectSysAuthInfoBySysId(sysId);
    }

    /**
     * 查询登录权限控制列表
     * 
     * @param sysAuthInfo 登录权限控制
     * @return 登录权限控制
     */
    @Override
    public List<SysAuthInfo> selectSysAuthInfoList(SysAuthInfo sysAuthInfo)
    {
        return sysAuthInfoMapper.selectSysAuthInfoList(sysAuthInfo);
    }

    /**
     * 新增登录权限控制
     * 
     * @param sysAuthInfo 登录权限控制
     * @return 结果
     */
    @Override
    public int insertSysAuthInfo(SysAuthInfo sysAuthInfo)
    {
        return sysAuthInfoMapper.insertSysAuthInfo(sysAuthInfo);
    }

    /**
     * 修改登录权限控制
     * 
     * @param sysAuthInfo 登录权限控制
     * @return 结果
     */
    @Override
    public int updateSysAuthInfo(SysAuthInfo sysAuthInfo)
    {
        return sysAuthInfoMapper.updateSysAuthInfo(sysAuthInfo);
    }

    /**
     * 批量删除登录权限控制
     * 
     * @param sysIds 需要删除的登录权限控制主键
     * @return 结果
     */
    @Override
    public int deleteSysAuthInfoBySysIds(Long[] sysIds)
    {
        return sysAuthInfoMapper.deleteSysAuthInfoBySysIds(sysIds);
    }

    /**
     * 删除登录权限控制信息
     * 
     * @param sysId 登录权限控制主键
     * @return 结果
     */
    @Override
    public int deleteSysAuthInfoBySysId(Long sysId)
    {
        return sysAuthInfoMapper.deleteSysAuthInfoBySysId(sysId);
    }
}
