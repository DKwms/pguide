package com.zyc.download4j.core.source.reflect;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 反射器，通过反射获得值。
 */
public interface Reflector {

    Object reflect(Object model);
}
