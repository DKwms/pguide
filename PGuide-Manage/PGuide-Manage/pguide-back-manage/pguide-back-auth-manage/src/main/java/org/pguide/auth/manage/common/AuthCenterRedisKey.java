package org.pguide.auth.manage.common;

/**
 * @author DKwms
 * @Date 2024/1/5 19:26
 * @description
 */
public interface AuthCenterRedisKey {

    /**
     * 返回List<String>：SYS_name  <br/>
     * 加载当前开放系统 <br/>
     * 对应的用户列表用系统名前缀加载
     *
     */
    String PGUIDE_REDIS_SYS_NAME_LIST = "pguide_auth_Strategy_entity_key";

    /**
     * 系统名前缀<br/>
     * 前缀+后缀 -> 取出用户列表
     */

    String PGUIDE_REDIS_SYS_NAME_PRE = "pguide_auth_sys_name_pre_";

}
