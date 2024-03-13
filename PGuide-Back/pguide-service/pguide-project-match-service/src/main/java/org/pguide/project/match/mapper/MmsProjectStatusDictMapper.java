package org.pguide.project.match.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.project.match.entity.MmsProjectStatusDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
* @author ROG
* @description 针对表【mms_project_status_dict】的数据库操作Mapper
* @createDate 2024-01-29 15:36:35
* @Entity org.pguide.project.match.entity.MmsProjectStatusDict
*/
@Mapper
public interface MmsProjectStatusDictMapper extends BaseMapper<MmsProjectStatusDict> {

}




