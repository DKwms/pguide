package org.pguide.common.page.utils;

import com.github.pagehelper.PageInfo;
import org.pguide.common.core.result.JsonResult;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/2/6 16:22
 * @description
 */
public class PageUtil {

    /**
     * 获取分页信息
     * @param objList
     * @return
     */
    public static PageInfo<?> getPageInfo(List<?> objList){
        PageInfo<?> pageInfo = new PageInfo<>(objList);
        return pageInfo;
    }

    /**
     * 获取分页结果<br>
     *
     * 总页数
     *int pages;
     * 总条数
     *long total;
     * 当前页数
     *int pageNum;
     * 当前条数
     *int size;
     *
     * 默认数据
     * List<?> list;
     * @param objList
     * @return
     */

    public static JsonResult<PageVo> getPageResult(List<?> objList){
        PageInfo<?> pageinfo = getPageInfo(objList);

        PageVo pageVo = PageVo.builder()
                .pages(pageinfo.getPages())
                .total(pageinfo.getTotal())
                .pageNum(pageinfo.getPageNum())
                .size(pageinfo.getSize())
                .list(objList)
                .build();

        return JsonResult.success(pageVo);
    }
}
