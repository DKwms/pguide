package org.pguide.project.match.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.project.match.entity.MmsProjectBelongInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
* @author ROG
* @description 针对表【mms_project_belong_info】的数据库操作Mapper
* @createDate 2024-01-29 15:36:36
* @Entity org.pguide.project.match.entity.MmsProjectBelongInfo
*/
@Mapper
public interface MmsProjectBelongInfoMapper extends BaseMapper<MmsProjectBelongInfo> {

}




