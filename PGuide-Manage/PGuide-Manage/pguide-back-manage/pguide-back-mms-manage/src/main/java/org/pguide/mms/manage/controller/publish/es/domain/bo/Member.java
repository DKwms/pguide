package org.pguide.mms.manage.controller.publish.es.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2024/1/23 10:40
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    private int memberId;
    private String memberType;
    private String memberName;
}
