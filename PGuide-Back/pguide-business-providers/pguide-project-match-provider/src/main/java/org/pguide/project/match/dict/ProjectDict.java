package org.pguide.project.match.dict;

import org.pguide.project.match.entity.MmsProjectStatusDict;
import org.pguide.project.match.entity.MmsProjectTypeInfo;
import org.pguide.project.match.service.impl.MmsProjectStatusDictServiceImpl;
import org.pguide.project.match.service.impl.MmsProjectTypeInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author DKwms
 * @Date 2024 02 2024/2/3 16 12
 */

@Component
public class ProjectDict {
    /**
     * 项目类型字典
     */

    // 项目状态字典表,状态名：id
    public Map<String, Integer>  PROJECT_STATUS_MAP_DICT;

    // 项目状态字典表
    public List<MmsProjectTypeInfo>  PROJECT_TYPE_DICT;

    // 用户状态表


    @Autowired
    MmsProjectStatusDictServiceImpl mmsProjectStatusDictService;

    @Autowired
    MmsProjectTypeInfoServiceImpl mmsProjectTypeInfoService;

    @PostConstruct
    public void init() {
        PROJECT_STATUS_MAP_DICT = mmsProjectStatusDictService.list().stream().collect(
                Collectors.toMap(MmsProjectStatusDict::getProjectStatusName, MmsProjectStatusDict::getProjectStatusId)
        );

        this.PROJECT_TYPE_DICT = mmsProjectTypeInfoService.list();
    }



    

}
