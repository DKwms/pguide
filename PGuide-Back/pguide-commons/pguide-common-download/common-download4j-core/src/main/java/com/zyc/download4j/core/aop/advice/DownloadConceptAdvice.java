package com.zyc.download4j.core.aop.advice;

import com.zyc.download4j.core.aop.annotation.CompressCache;
import com.zyc.download4j.core.aop.annotation.Download;
import com.zyc.download4j.core.aop.annotation.SourceCache;
import com.zyc.download4j.core.concept.DownloadConcept;
import com.zyc.download4j.core.concept.ValueContainer;
import com.zyc.download4j.core.configuration.DownloadConfiguration;
import com.zyc.download4j.core.exception.DownloadException;
import com.zyc.download4j.core.options.DownloadMethod;
import com.zyc.download4j.core.options.DownloadOptions;
import lombok.Data;
import lombok.NonNull;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 下载功能的AOP拦截。
 * 对标注了注解 {@link Download} 的方法进行拦截。
 */
@Data
public class DownloadConceptAdvice extends DefaultPointcutAdvisor implements MethodInterceptor, BeanPostProcessor {

    private DownloadConfiguration configuration;

    private DownloadConcept downloadConcept;

    public DownloadConceptAdvice() {
        setPointcut(new AnnotationMatchingPointcut(null, Download.class, true));
        setAdvice(this);
        setOrder(Ordered.LOWEST_PRECEDENCE);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object[] arguments = invocation.getArguments();
        Object returnValue = unwrap(invocation.proceed());
        DownloadOptions options = buildOptions(method, arguments, returnValue, configuration);
        return downloadConcept.download(options);
    }

    private Object unwrap(Object value) {
        if (value instanceof ValueContainer) {
            return ((ValueContainer) value).getValue();
        } else {
            return value;
        }
    }

    public DownloadOptions buildOptions(Method method,
                                        Object[] parameters,
                                        Object returnValue,
                                        DownloadConfiguration configuration) {

        Download download = method.getAnnotation(Download.class);
        SourceCache sourceCache = method.getAnnotation(SourceCache.class);
        CompressCache compressCache = method.getAnnotation(CompressCache.class);

        DownloadOptions.Builder builder = DownloadOptions.builder();

        DownloadMethod downloadMethod = DownloadMethod.builder()
                .method(method)
                .parameters(parameters)
                .returnValue(returnValue)
                .build();

        builder.downloadMethod(downloadMethod);

        //如果是 DownloadOptions 直接使用
        if (returnValue instanceof DownloadOptions) {
            return (DownloadOptions) returnValue;
        }
        //如果为 null 或 Rewriter 则使用注解指定的数据，否则使用返回值
        if (returnValue == null || returnValue instanceof DownloadOptions.Rewriter) {
            builder.source(download.source());
        } else {
            builder.source(returnValue);
        }

        builder.filename(download.filename())
                .inline(download.inline())
                .contentType(download.contentType())
                .compressFormat(buildCompressFormat(download, configuration))
                .forceCompress(download.forceCompress())
                .charset(buildCharset(download))
                .headers(buildHeaders(download, configuration))
                .extra(download.extra());

        if (sourceCache == null) {
            DownloadConfiguration.CacheConfiguration cache =
                    configuration.getSource().getCache();
            builder.sourceCacheEnabled(cache.isEnabled())
                    .sourceCachePath(cache.getPath())
                    .sourceCacheDelete(cache.isDelete());
        } else {
            builder.sourceCacheEnabled(sourceCache.enabled())
                    .sourceCachePath(buildSourceCachePath(sourceCache, configuration))
                    .sourceCacheDelete(sourceCache.delete());
        }

        if (compressCache == null) {
            DownloadConfiguration.CacheConfiguration cache =
                    configuration.getCompress().getCache();
            builder.compressCacheEnabled(cache.isEnabled())
                    .compressCachePath(cache.getPath())
                    .compressCacheDelete(cache.isDelete());
        } else {
            builder.compressCacheEnabled(compressCache.enabled())
                    .compressCachePath(buildCompressPath(compressCache, configuration))
                    .compressCacheName(compressCache.name())
                    .compressCacheDelete(compressCache.delete());
        }

        DownloadOptions options = builder.build();

        if (returnValue instanceof DownloadOptions.Rewriter) {
            //回调重写接口
            return ((DownloadOptions.Rewriter) returnValue).rewrite(options);
        } else {
            return options;
        }
    }

    private String buildCompressFormat(Download download, DownloadConfiguration configuration) {
        String compressFormat = download.compressFormat();
        if (StringUtils.hasText(compressFormat)) {
            return compressFormat;
        } else {
            return configuration.getCompress().getFormat();
        }
    }

    private Charset buildCharset(Download download) {
        String charset = download.charset();
        return StringUtils.hasText(charset) ? Charset.forName(charset) : null;
    }

    private Map<String, String> buildHeaders(Download download, DownloadConfiguration configuration) {
        Map<String, String> headerMap = new LinkedHashMap<>();
        Map<String, String> globalHeaders = configuration.getResponse().getHeaders();
        //全局响应头
        if (globalHeaders != null) {
            headerMap.putAll(globalHeaders);
        }
        //注解上指定的响应头
        String[] headers = download.headers();
        if (headers.length % 2 == 0) {
            for (int i = 0; i < headers.length; i += 2) {
                headerMap.put(headers[i], headers[i + 1]);
            }
            return headerMap;
        } else {
            throw new DownloadException("Headers params % 2 != 0");
        }
    }

    private String buildSourceCachePath(SourceCache cache, DownloadConfiguration configuration) {
        String path = configuration.getSource().getCache().getPath();
        if (cache.group().isEmpty()) {
            return path;
        } else {
            return new File(path, cache.group()).getAbsolutePath();
        }
    }

    private String buildCompressPath(CompressCache cache, DownloadConfiguration configuration) {
        String path = configuration.getCompress().getCache().getPath();
        if (cache.group().isEmpty()) {
            return path;
        } else {
            return new File(path, cache.group()).getAbsolutePath();
        }
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (bean instanceof DownloadConcept) {
            this.downloadConcept = (DownloadConcept) bean;
        } else if (bean instanceof DownloadConfiguration) {
            this.configuration = (DownloadConfiguration) bean;
        }
        return bean;
    }
}
