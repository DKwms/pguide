package com.pguide.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.pguide.project.controller.dto.ProjectLogAllInfoDto;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pguide.project.mapper.ProjectLogDetailMapper;
import com.pguide.project.service.IProjectLogDetailService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author dkwms
 * @date 2023-08-19
 */
@Service
public class ProjectLogDetailServiceImpl implements IProjectLogDetailService 
{
    @Autowired
    private ProjectLogDetailMapper projectLogDetailMapper;

    /**
     * 返回全部日志信息
     * @return
     */
    @Override
    public ArrayList<ArrayList<ProjectLogAllInfoDto>> selectProjectLogInfoList() {

        Stream<ProjectLogAllInfoDto> dtoStream = filterByCondiction();

        ArrayList<ArrayList<ProjectLogAllInfoDto>> lists = new ArrayList(){{
            this.add(dtoStream);
            System.out.println(dtoStream);
        }};
        return lists;
    }

    public Stream<ProjectLogAllInfoDto> filterByCondiction(){

        Stream<ProjectLogAllInfoDto> dtoStream = projectLogDetailMapper
                .selectAllLogInfolist()
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
