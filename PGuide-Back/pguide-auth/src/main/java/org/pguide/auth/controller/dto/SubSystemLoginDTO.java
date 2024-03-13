package org.pguide.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DKwms
 * @Date 2023/10/2 15:29
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubSystemLoginDTO {
    private String token;
    private String redirectUrl;
}
