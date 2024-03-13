package org.pguide.common.security.constant;



/**
 * @author DKwms
 * @Date 2024/1/30 15:57
 * @description
 */
public interface AuthConst {

    /**
     * 鉴权相关信息在redis中的key
     */
    interface AuthRedisConst{
        String PGUIDE_REDIS_SYS_USER_MAP = "pguide_sys_user_type";
    }

    /**
     * 切面authKey，权限符常量，
     * 在header中
     */
    interface AspectAuthKeyConst{
        // 请求头中，authkey的key
        String SYS_USER_AUTH_KEY_IN_HEADER = "SysAuthKey";
        // 白名单权限
        String FULL_AUTH_VALUE = "*:*";
    }

    /**
     * 系统常量表
     */
    interface SystemTypeConst{
        String PGUIDE = "pguide";
        String PGUIDE_SPD = "spd";
    }

    /**
     * 用户常量表
     */
    interface UserTypeConst{
        String PGUIDE_STUDENT = "student";

        String PGUIDE_TEACHERROR = "teacher";

        String PGUIDE_SPD_USER = "spd-user";
    }


}
