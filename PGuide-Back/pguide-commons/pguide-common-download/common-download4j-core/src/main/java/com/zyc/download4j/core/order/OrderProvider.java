package com.zyc.download4j.core.order;

import org.springframework.core.Ordered;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 提供排序支持。
 */
public interface OrderProvider extends Ordered {

    default int getOrder() {
        return 0;
    }
}
