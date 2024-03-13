package org.pguide.mms.manage.controller.publish.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2024/2/20 17:26
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectPublishUpdatedVo {
    Integer status_id;
    String projectName;
}
