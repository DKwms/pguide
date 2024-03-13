package com.pguide.project.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pguide.project.controller.dto.ProjectLogAllInfoDto;
import com.pguide.project.controller.vo.ProjectLogVo;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@DataSource(value = DataSourceType.MASTER)
public interface ProjectLogDetailMapper 
{
    /**
     * 返回日志的全部信息
     * @return ProjectLogAllInfo
     */
    List<ProjectLogAllInfoDto> selectAllLogInfolist();

}
