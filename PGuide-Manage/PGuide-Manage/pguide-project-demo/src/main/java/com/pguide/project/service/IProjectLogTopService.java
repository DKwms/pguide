package com.pguide.project.service;

import java.util.ArrayList;
import java.util.List;

import com.pguide.project.controller.dto.ProjectLogAllInfoDto;
import com.pguide.project.controller.vo.ProjectLogVo;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author dkwms
 * @date 2023-08-19
 */
public interface IProjectLogTopService 
{
    ArrayList<ArrayList<ProjectLogAllInfoDto>> selectLogPage(ProjectLogVo vo);
}
