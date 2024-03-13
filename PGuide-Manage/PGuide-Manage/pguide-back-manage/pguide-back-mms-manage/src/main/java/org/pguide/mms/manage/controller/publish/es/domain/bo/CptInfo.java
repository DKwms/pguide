package org.pguide.mms.manage.controller.publish.es.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2024/1/23 10:41
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CptInfo {
    private String cptName;
    private String cptType;
}
