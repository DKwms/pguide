package com.zyc.download4j.core.utils;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 工具类。
 */
public class DownloadUtils {

    public static String format(long size) {
        if (size >= 1024) {
            double k = size / 1024.0;
            if (k >= 1024) {
                double m = k / 1024;
                return String.format("%.2f", m) + "M";
            } else {
                return String.format("%.2f", k) + "K";
            }
        } else {
            return size + "B";
        }
    }
}
