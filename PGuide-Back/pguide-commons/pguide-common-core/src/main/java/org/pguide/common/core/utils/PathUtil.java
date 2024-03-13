package org.pguide.common.core.utils;

import cn.hutool.core.text.AntPathMatcher;
import org.springframework.util.StringUtils;


/**
 * @author DKwms
 * @Date 2024/2/1 19:39
 * @description /** 统配路径处理
 *
 * 最开始手写的，但确实有点麻烦，还是用hutool的
 */
public class PathUtil {

    public static boolean checkAuthKeyValue(String path, String aimPath) {
        if(StringUtils.isEmpty(path) || StringUtils.isEmpty(aimPath)) return false;
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        return antPathMatcher.match(path,aimPath);
    }

}
