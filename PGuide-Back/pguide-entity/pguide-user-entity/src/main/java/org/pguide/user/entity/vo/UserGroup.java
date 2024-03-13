package org.pguide.user.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2024/1/20 16:19
 * @description
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup {
    private String groupName;
    private String groupId;
}
