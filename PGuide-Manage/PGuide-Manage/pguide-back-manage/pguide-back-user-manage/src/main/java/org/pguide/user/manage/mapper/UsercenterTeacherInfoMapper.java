package org.pguide.user.manage.mapper;


import org.pguide.user.manage.entity.UsercenterTeacherInfo;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author dkwms
 * @date 2024-01-02
 */
public interface UsercenterTeacherInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param teacherId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public UsercenterTeacherInfo selectUsercenterTeacherInfoByTeacherId(Integer teacherId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param usercenterTeacherInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<UsercenterTeacherInfo> selectUsercenterTeacherInfoList(UsercenterTeacherInfo usercenterTeacherInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param usercenterTeacherInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertUsercenterTeacherInfo(UsercenterTeacherInfo usercenterTeacherInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param usercenterTeacherInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateUsercenterTeacherInfo(UsercenterTeacherInfo usercenterTeacherInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param teacherId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteUsercenterTeacherInfoByTeacherId(Integer teacherId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param teacherIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUsercenterTeacherInfoByTeacherIds(Integer[] teacherIds);
}
