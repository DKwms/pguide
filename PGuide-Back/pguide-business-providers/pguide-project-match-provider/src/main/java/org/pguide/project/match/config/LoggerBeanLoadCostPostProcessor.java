package org.pguide.project.match.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author DKwms
 * @Date 2024/2/1 22:44
 * @description
 */
@Component
public class LoggerBeanLoadCostPostProcessor implements BeanPostProcessor {

    private static Logger logger = LoggerFactory.getLogger(LoggerBeanLoadCostPostProcessor.class);

    private static Map<String, Long> cost = new HashMap<>(10000);

    private static AtomicInteger beanCount = new AtomicInteger(0);


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.debug("beanName:{},begintime : {}",
                beanName,System.currentTimeMillis());
        cost.put(beanName, System.currentTimeMillis());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        beanCount.incrementAndGet();
        if(cost.get(beanName) == null){
            logger.warn("beanCount : {} ,cost.get(beanName : {} ) is null",beanCount.get(),beanName);
        }else{
            logger.debug("beanCount : {},beanName:{}, ,cost : {}",
                    beanCount.get(),
                    beanName, (System.currentTimeMillis()- cost.get(beanName)));
        }

        return bean;
    }
}
