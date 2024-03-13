package org.pguide.user.manage.mapper;


import org.pguide.user.manage.entity.UsercenterStudentInfo;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author dkwms
 * @date 2024-01-02
 */
public interface UsercenterStudentInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public UsercenterStudentInfo selectUsercenterStudentInfoByStudentId(Long studentId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param usercenterStudentInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<UsercenterStudentInfo> selectUsercenterStudentInfoList(UsercenterStudentInfo usercenterStudentInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param usercenterStudentInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertUsercenterStudentInfo(UsercenterStudentInfo usercenterStudentInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param usercenterStudentInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateUsercenterStudentInfo(UsercenterStudentInfo usercenterStudentInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteUsercenterStudentInfoByStudentId(Long studentId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUsercenterStudentInfoByStudentIds(Long[] studentIds);
}
