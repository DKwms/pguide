package org.pguide.user.manage.service.impl;


import org.pguide.user.manage.entity.UsercenterTeacherInfo;
import org.pguide.user.manage.mapper.UsercenterTeacherInfoMapper;
import org.pguide.user.manage.service.IUsercenterTeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author dkwms
 * @date 2024-01-02
 */
@Service
public class UsercenterTeacherInfoServiceImpl implements IUsercenterTeacherInfoService
{
    @Autowired
    private UsercenterTeacherInfoMapper usercenterTeacherInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param teacherId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public UsercenterTeacherInfo selectUsercenterTeacherInfoByTeacherId(Integer teacherId)
    {
        return usercenterTeacherInfoMapper.selectUsercenterTeacherInfoByTeacherId(teacherId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param usercenterTeacherInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<UsercenterTeacherInfo> selectUsercenterTeacherInfoList(UsercenterTeacherInfo usercenterTeacherInfo)
    {
        return usercenterTeacherInfoMapper.selectUsercenterTeacherInfoList(usercenterTeacherInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param usercenterTeacherInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertUsercenterTeacherInfo(UsercenterTeacherInfo usercenterTeacherInfo)
    {
        return usercenterTeacherInfoMapper.insertUsercenterTeacherInfo(usercenterTeacherInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param usercenterTeacherInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateUsercenterTeacherInfo(UsercenterTeacherInfo usercenterTeacherInfo)
    {
        return usercenterTeacherInfoMapper.updateUsercenterTeacherInfo(usercenterTeacherInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param teacherIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteUsercenterTeacherInfoByTeacherIds(Integer[] teacherIds)
    {
        return usercenterTeacherInfoMapper.deleteUsercenterTeacherInfoByTeacherIds(teacherIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param teacherId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteUsercenterTeacherInfoByTeacherId(Integer teacherId)
    {
        return usercenterTeacherInfoMapper.deleteUsercenterTeacherInfoByTeacherId(teacherId);
    }
}
