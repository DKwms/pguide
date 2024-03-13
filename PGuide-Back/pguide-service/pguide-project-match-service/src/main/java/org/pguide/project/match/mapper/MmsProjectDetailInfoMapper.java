package org.pguide.project.match.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.project.match.entity.MmsProjectDetailInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author ROG
* @description 针对表【mms_project_detail_info】的数据库操作Mapper
* @createDate 2024-02-04 21:28:07
* @Entity org.pguide.project.match.entity.MmsProjectDetailInfo
*/
@Mapper
public interface MmsProjectDetailInfoMapper extends BaseMapper<MmsProjectDetailInfo> {

}




