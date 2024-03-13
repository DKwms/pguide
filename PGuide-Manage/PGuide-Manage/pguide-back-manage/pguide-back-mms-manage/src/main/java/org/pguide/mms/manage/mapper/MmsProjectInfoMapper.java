package org.pguide.mms.manage.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.pguide.mms.manage.controller.publish.es.domain.dto.ProjectInfo;
import org.pguide.mms.manage.controller.publish.vo.ProjectPublishUpdatedVo;
import org.pguide.mms.manage.controller.publish.vo.ProjectPublishVo;
import org.pguide.mms.manage.domain.MmsProjectInfo;

/**
 * 项目信息主表Mapper接口
 * 
 * @author dkwms
 * @date 2024-01-16
 */
@Mapper
@DataSource(DataSourceType.MMS)
public interface MmsProjectInfoMapper 
{

    /**
     * 审核页主搜索api
     */
    public  List<ProjectPublishVo> selectPublishVo(@Param("projectVo") ProjectPublishVo projectPublishVo);

    /**
     * 更新项目状态
     * @param projectPublishUpdatedVo
     */
    int updateMmsProjectInfoStatus(@Param("puv") ProjectPublishUpdatedVo projectPublishUpdatedVo);

    /**
     * 生成es需要的projectInfo数据，通过projectName
     * @param projectName 项目名
     * @return
     */
    ProjectInfo selectMmsProjectInfoToESByProjectName(@Param("name") String projectName);

    /**
     * 查询项目信息主表
     * 
     * @param projectId 项目信息主表主键
     * @return 项目信息主表
     */
    public MmsProjectInfo selectMmsProjectInfoByProjectId(Long projectId);

    /**
     * 查询项目信息主表列表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 项目信息主表集合
     */
    public List<MmsProjectInfo> selectMmsProjectInfoList(MmsProjectInfo mmsProjectInfo);

    /**
     * 新增项目信息主表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 结果
     */
    public int insertMmsProjectInfo(MmsProjectInfo mmsProjectInfo);

    /**
     * 修改项目信息主表
     * 
     * @param mmsProjectInfo 项目信息主表
     * @return 结果
     */
    public int updateMmsProjectInfo(MmsProjectInfo mmsProjectInfo);

    /**
     * 删除项目信息主表
     * 
     * @param projectId 项目信息主表主键
     * @return 结果
     */
    public int deleteMmsProjectInfoByProjectId(Long projectId);

    /**
     * 批量删除项目信息主表
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsProjectInfoByProjectIds(Long[] projectIds);


}
