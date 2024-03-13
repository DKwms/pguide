package org.pguide.studio.place.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pguide.studio.place.entity.StudioPlacePeople;

import java.util.ArrayList;


/**
 * @Author DKwms
 * @Date 2023 10 2023/10/24 20 02
 * 时间表的dto
 * 单天表框信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeBlockDto {

   public ArrayList<StudioPlacePeople> peopleList;


}
