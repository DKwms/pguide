package org.pguide.common.security.utils;

/**
 * @author DKwms
 * @Date 2024/1/31 14:55
 * @description
 */
public class AuthKeyUtil {

    /**
     * 检测是否相等，支持*号统配
     * @param authKey
     * @param requestAuthKey
     * @return
     */
    public static boolean checkAuthKeyValue(String authKey, String requestAuthKey) {
        String[] authKeyLevels = authKey.split(":");
        String[] requestAuthKeyLevels = requestAuthKey.split(":");
        if(authKeyLevels.length != requestAuthKeyLevels.length) return false;
        for (int i = 0; i < requestAuthKeyLevels.length; i++) {
            String authKeyLevel = authKeyLevels[i];
            String requestAuthKeyLevel = requestAuthKeyLevels[i];
            if("*".equals(requestAuthKeyLevel)) continue;
            if("*".equals(authKeyLevel)) continue;
            if(!authKeyLevel.equals(requestAuthKeyLevel)) return false;
        }
        return true;
    }
}
