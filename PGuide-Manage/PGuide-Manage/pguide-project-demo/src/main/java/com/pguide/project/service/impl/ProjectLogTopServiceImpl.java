package com.pguide.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.pguide.project.controller.dto.ProjectLogAllInfoDto;
import com.pguide.project.controller.vo.ProjectLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pguide.project.mapper.ProjectLogTopMapper;
import com.pguide.project.service.IProjectLogTopService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@Service
public class ProjectLogTopServiceImpl implements IProjectLogTopService 
{
    @Autowired
    private ProjectLogTopMapper projectLogTopMapper;
    Integer size = 4;

    /**
     * 分页查询
     */
    @Override
    public ArrayList<ArrayList<ProjectLogAllInfoDto>> selectLogPage(ProjectLogVo vo) {

        // Stream<ProjectLogAllInfoDto> dtoStream = filterByCondiction(vo);
        ArrayList<ArrayList<ProjectLogAllInfoDto>> lists = new ArrayList(){{
            this.add(projectLogTopMapper.selectLogPage(vo,size));
        }};

        return lists;
    }

    public Stream<ProjectLogAllInfoDto> filterByCondiction(ProjectLogVo vo) {

        Stream<ProjectLogAllInfoDto> dtoStream = projectLogTopMapper
                .selectLogPage(vo, size)
                .stream()
                .filter(Objects::nonNull)
                .peek(projectLogAllInfoDto -> {
                    String info = projectLogAllInfoDto.getLogInfo();
                    info = "- ".concat(info).replace("|", "</br>- ");
                    projectLogAllInfoDto.setLogInfo(info);
                });

        return dtoStream;
    }
}
