package com.zyc.download4j.core.configuration;

import com.zyc.download4j.core.cache.Cacheable;
import com.zyc.download4j.core.compress.CompressFormat;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 全局下载配置。
 */
@Data
@ConfigurationProperties(prefix = "common.download")
public class DownloadConfiguration {

    private ResponseConfiguration response = new ResponseConfiguration();

    private SourceConfiguration source = new SourceConfiguration();

    private CompressConfiguration compress = new CompressConfiguration();

    private LoggerConfiguration logger = new LoggerConfiguration();

    @Data
    public static class ResponseConfiguration {
        private Map<String, String> headers;
    }

    @Data
    public static class SourceConfiguration {

        private CacheConfiguration cache = new CacheConfiguration();
    }

    @Data
    public static class CompressConfiguration {
        private String format = CompressFormat.ZIP;

        private CacheConfiguration cache = new CacheConfiguration();
    }

    @Data
    public static class CacheConfiguration {

        private boolean enabled;

        private String path = Cacheable.PATH;

        private boolean delete;
    }

    @Data
    public static class LoggerConfiguration {

        private boolean enabled;

        private StandardLoggerConfiguration standard = new StandardLoggerConfiguration();

        private TimeSpentLoggerConfiguration timeSpent = new TimeSpentLoggerConfiguration();

        private ProgressLoggerConfiguration progress = new ProgressLoggerConfiguration();
    }

    @Data
    public static class StandardLoggerConfiguration {

        private boolean enabled = true;
    }

    @Data
    public static class TimeSpentLoggerConfiguration {

        private boolean enabled = true;
    }

    @Data
    public static class ProgressLoggerConfiguration {

        private boolean enabled = true;

        private int duration = 1000;

        private boolean percentage;
    }
}
