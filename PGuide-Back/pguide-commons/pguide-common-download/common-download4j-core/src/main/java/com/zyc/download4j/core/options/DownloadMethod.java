package com.zyc.download4j.core.options;

import lombok.Builder;
import lombok.Value;

import java.lang.reflect.Method;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载方法，切面中拦截的方法。
 */
@Value
@Builder(builderClassName = "Builder")
public class DownloadMethod {

    Method method;

    Object[] parameters;

    Object returnValue;
}
