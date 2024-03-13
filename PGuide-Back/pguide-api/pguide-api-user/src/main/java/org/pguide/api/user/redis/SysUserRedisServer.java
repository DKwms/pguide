package org.pguide.api.user.redis;

import org.pguide.common.redis.service.RedisService;
import org.pguide.common.security.constant.AuthConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author DKwms
 * @Date 2024/1/30 15:33
 * @description 系统用户类型
 */
@Service
public class SysUserRedisServer {

    @Autowired
    RedisService redisService;

    //@Autowired
    //SysAuthInfoServiceImpl sysAuthInfoService;

    String SUMAP_KEY = AuthConst.AuthRedisConst.PGUIDE_REDIS_SYS_USER_MAP;

    //TODO get the suMap from redis,if find null,cas until get the data
    public Map<String, List<String>> getSystemTypeUserMap() {
        return (Map<String, List<String>>)redisService.getObj(SUMAP_KEY);
    }


    //TODO use openfeign because it use the db
    //public void setSystemTypeUserMapFromMysql() {
    //
    //    List<SysAuthInfo> list = sysAuthInfoService.list();
    //    Map<String, List<String>> suMap = list.stream()
    //            .filter(
    //                    e -> "open".equals(e.getSysType())
    //            )
    //            .collect(
    //                    Collectors.toMap(
    //                            SysAuthInfo::getSysName,
    //                            e -> {
    //                                String[] split = e.getSysUser().split(";");
    //                                return Arrays.asList(split);
    //                            })
    //            );
    //
    //    redisService.setObj(SUMAP_KEY,suMap);
    //
    //}


}
