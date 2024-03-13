package com.pguide.project.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DKwms
 * @Date 2023/8/19 10:57
 * @description
 */

@Configuration
@MapperScan("com.pguide.**.mapper")
public class ProjectConfiguration {
}
