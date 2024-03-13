package org.pguide.common.page.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/2/6 16:31
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PageVo {

    // 总页数
    int pages;

    // 总条数
    long total;

    // 当前页数
    int pageNum;

    // 当前条数
    int size;

    List<?> list;
}
