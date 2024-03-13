package com.pguide.project.mapper;

import java.util.List;

import com.pguide.project.controller.dto.ProjectTaskDto;
import com.pguide.project.controller.vo.ProjectTaskAddVo;
import com.pguide.project.domain.ProjectTask;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *  Mapper接口
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@Mapper
@DataSource(value = DataSourceType.MASTER)
public interface ProjectTaskMapper 
{
    /**
     * 查询 
     * 
     * @param taskId  主键
     * @return  
     */
    public ProjectTask selectProjectTaskByTaskId(Long taskId);

    /**
     * 查询 列表
     * 
     * @param projectTask  
     * @return  集合
     */
    public List<ProjectTask> selectProjectTaskList(ProjectTask projectTask);

    /**
     * 新增 
     * 
     * @param projectTask  
     * @return 结果
     */
    public int insertProjectTask(ProjectTask projectTask);

    /**
     * 修改 
     * 
     * @param projectTask  
     * @return 结果
     */
    public int updateProjectTask(ProjectTask projectTask);

    /**
     * 删除 
     * 
     * @param taskId  主键
     * @return 结果
     */
    public int deleteProjectTaskByTaskId(Long taskId);

    /**
     * 批量删除 
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProjectTaskByTaskIds(Long[] taskIds);

    List<ProjectTask> getTasksByTaskId(@Param("taskIdByUser") List<Long> taskIdByUser);

    /**
     * 获取tag dto
     * @param taskIdByUser
     * @return
     */
    List<ProjectTaskDto> getTaskDtosByTaskId(@Param("taskIdByUser") List<Long> taskIdByUser);

    int addFormVo(ProjectTaskAddVo adder);
}
