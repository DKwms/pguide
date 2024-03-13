package org.pguide.studio.place.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pguide.studio.place.entity.StudioPlacePeople;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author User
* @description 针对表【studio_place_people】的数据库操作Mapper
* @createDate 2023-10-24 19:39:30
* @Entity org.pguide.studio.place.entity.StudioPlacePeople
*/

@Mapper
public interface StudioPlacePeopleMapper extends BaseMapper<StudioPlacePeople> {

}




