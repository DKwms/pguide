package org.pguide.common.page.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.pguide.common.core.utils.StringUtils;
import org.pguide.common.page.annotation.EasyPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.github.pagehelper.PageHelper;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DKwms
 * @Date 2024/2/6 15:07
 * @description
 */

@Aspect
@Component
@Slf4j
public class PageHelperAspect {

    @Value("${pguide.common.page.pagesize.min:-1}")
    int DEFAULT_MIN_PAGESIZE = -1;

    @Value("${pguide.common.page.pagesize.max:50}")
    int DEFAULT_MAX_PAGESIZE = 50;

    @Value("${pguide.common.page.pagesize.value:5")
    int DEFAULT_VALUE_PAGESIZE = 5;

    @Value("${pguide.common.page.pagenum.min:1}")
    int DEFAULT_MIN_PAGENUM = -1;
    // -1 代表无最高上限
    @Value("${pguide.common.page.pagenum.max:-1}")
    int DEFAULT_MAX_PAGENUM = -1;

    @Value("${pguide.common.page.pagenum.value:1")
    int DEFAULT_VALUE_PAGENUM = 1;



    @Before("@annotation(easyPage)")
    public void pageAop(JoinPoint joinPoint, EasyPage easyPage) throws Throwable {
        // 注解参数解析，默认-1是走系统配置
        int MAX_PAGESIZE = easyPage.value();
        int MAX_PAGENUM = easyPage.pageMaxNum();
        boolean pageOrder = easyPage.pageOrder();

        // 请求参数解析
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String requestPageSizeParam = request.getParameter("pageSize");
        String requestPageNumParam = request.getParameter("pageNum");
        log.info("[获取前端body参数]num:{},size:{}",requestPageNumParam,requestPageSizeParam);

            // 没有参数默认是系统配置的默认值
        int requestPageSize = DEFAULT_VALUE_PAGESIZE;
        int requestPageNum = DEFAULT_VALUE_PAGENUM;
        if(!StringUtils.isEmpty(requestPageSizeParam)){
            // 传入参数不为空，使用用户定义的参数
            requestPageSize = Integer.parseInt(requestPageSizeParam);
                // 超出配置文件范围
            if(MAX_PAGESIZE==-1 && requestPageSize>DEFAULT_MAX_PAGESIZE) {
                // TODO 超出系统分页大小上限
            }else if(MAX_PAGESIZE!=-1 && requestPageSize>MAX_PAGESIZE){
                // TODO 超出接口注解分页大小上限
            }
        }
        if(!StringUtils.isEmpty(requestPageNumParam)){
            requestPageNum = Integer.parseInt(requestPageNumParam);
            if(MAX_PAGENUM==-1 && DEFAULT_MAX_PAGENUM!=-1 && requestPageNum > DEFAULT_MAX_PAGENUM){
                // TODO 分页深度超过系统上限
            }else if(MAX_PAGENUM!=-1 &&  requestPageNum > MAX_PAGENUM){
                // TODO 分页深度超过注解分页上限大小
            }
        }

        log.info("[最终]num:{},size:{}",requestPageNum,requestPageSize);

        PageHelper.startPage(requestPageNum, requestPageSize);
    }

    /**
     * 防止异常后没有清空pageHelper的分页缓存
     */
    @After("@annotation(easyPage)")
    public void pageAopClose(JoinPoint joinPoint, EasyPage easyPage) throws Throwable {
        PageHelper.clearPage();
    }

    @AfterThrowing("@annotation(easyPage)")
    public void pageAopCloseError(JoinPoint joinPoint, EasyPage easyPage) throws Throwable {
        PageHelper.clearPage();
    }
}
