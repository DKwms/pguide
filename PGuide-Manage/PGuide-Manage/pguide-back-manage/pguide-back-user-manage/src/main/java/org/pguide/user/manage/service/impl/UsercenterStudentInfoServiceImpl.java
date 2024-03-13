package org.pguide.user.manage.service.impl;

import java.util.List;

import org.pguide.user.manage.entity.UsercenterStudentInfo;
import org.pguide.user.manage.mapper.UsercenterStudentInfoMapper;
import org.pguide.user.manage.service.IUsercenterStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author dkwms
 * @date 2024-01-02
 */
@Service
public class UsercenterStudentInfoServiceImpl implements IUsercenterStudentInfoService
{
    @Autowired
    private UsercenterStudentInfoMapper usercenterStudentInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public UsercenterStudentInfo selectUsercenterStudentInfoByStudentId(Long studentId)
    {
        return usercenterStudentInfoMapper.selectUsercenterStudentInfoByStudentId(studentId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param usercenterStudentInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<UsercenterStudentInfo> selectUsercenterStudentInfoList(UsercenterStudentInfo usercenterStudentInfo)
    {
        return usercenterStudentInfoMapper.selectUsercenterStudentInfoList(usercenterStudentInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param usercenterStudentInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertUsercenterStudentInfo(UsercenterStudentInfo usercenterStudentInfo)
    {
        return usercenterStudentInfoMapper.insertUsercenterStudentInfo(usercenterStudentInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param usercenterStudentInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateUsercenterStudentInfo(UsercenterStudentInfo usercenterStudentInfo)
    {
        return usercenterStudentInfoMapper.updateUsercenterStudentInfo(usercenterStudentInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param studentIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteUsercenterStudentInfoByStudentIds(Long[] studentIds)
    {
        return usercenterStudentInfoMapper.deleteUsercenterStudentInfoByStudentIds(studentIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteUsercenterStudentInfoByStudentId(Long studentId)
    {
        return usercenterStudentInfoMapper.deleteUsercenterStudentInfoByStudentId(studentId);
    }
}
