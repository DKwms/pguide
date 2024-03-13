package org.pguide.auth.service.impl;

import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @author DKwms
 * @Date 2024/1/6 17:01
 * @description
 */
@Getter
public enum LoginEnum {
    TEACHER("teacher", "1"),
    STUDENT("student", "2"),
    SOD("spd", "3");


    LoginEnum(String reqHeader, String userType) {
        this.reqHeader = reqHeader;
        this.userType = userType;
    }

    private final String reqHeader;
    private final String userType;

    public String getUserTypeByHeader(String header) {
        assert StringUtils.hasText(header);
        LoginEnum[] values = values();
        for (LoginEnum l : values) {
            if (l.getReqHeader().equalsIgnoreCase(header)) {
                return l.getUserType();
            }
        }
        return null;
    }

}
