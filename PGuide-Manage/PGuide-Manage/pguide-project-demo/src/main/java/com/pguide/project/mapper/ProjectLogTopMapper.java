package com.pguide.project.mapper;

import java.util.List;

import com.pguide.project.controller.dto.ProjectLogAllInfoDto;
import com.pguide.project.controller.vo.ProjectLogVo;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author dkwms
 * @date 2023-08-19
 */
@DataSource(value = DataSourceType.MASTER)
public interface ProjectLogTopMapper {

    /**
     * 分页查询,支持多条件
     * @param vo
     * @return
     */
    List<ProjectLogAllInfoDto> selectLogPage(@Param("vo") ProjectLogVo vo, @Param("size") Integer size);
}
