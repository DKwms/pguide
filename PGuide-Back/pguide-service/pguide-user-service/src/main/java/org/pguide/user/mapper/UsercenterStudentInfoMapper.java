package org.pguide.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.user.entity.UsercenterStudentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.annotation.ManagedBean;

/**
* @author ROG
* @description 针对表【usercenter_student_info】的数据库操作Mapper
* @createDate 2024-01-02 15:29:30
* @Entity org.pguide.user.entity.UsercenterStudentInfo
*/
@Mapper
public interface UsercenterStudentInfoMapper extends BaseMapper<UsercenterStudentInfo> {

}




