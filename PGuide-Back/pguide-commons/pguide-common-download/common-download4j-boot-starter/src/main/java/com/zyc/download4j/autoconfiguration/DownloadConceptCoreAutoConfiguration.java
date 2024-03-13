package com.zyc.download4j.autoconfiguration;

import com.zyc.download4j.core.cache.CacheNameGenerator;
import com.zyc.download4j.core.cache.CacheNameGeneratorInitializer;
import com.zyc.download4j.core.cache.TimestampCacheNameGenerator;
import com.zyc.download4j.core.compress.DefaultSourceCompressorAdapter;
import com.zyc.download4j.core.compress.SourceCompressor;
import com.zyc.download4j.core.compress.SourceCompressorAdapter;
import com.zyc.download4j.core.compress.zip.ZipSourceCompressor;
import com.zyc.download4j.core.concept.ChainDownloadConcept;
import com.zyc.download4j.core.concept.DownloadConcept;
import com.zyc.download4j.core.concept.DownloadReturnInterceptor;
import com.zyc.download4j.core.configuration.DownloadConfiguration;
import com.zyc.download4j.core.configuration.DownloadConfigurer;
import com.zyc.download4j.core.configuration.DownloadConfigurerInvoker;
import com.zyc.download4j.core.context.*;
import com.zyc.download4j.core.event.ApplicationDownloadEventPublisher;
import com.zyc.download4j.core.event.DownloadEventListener;
import com.zyc.download4j.core.event.DownloadEventPublisher;
import com.zyc.download4j.core.event.DownloadEventPublisherInitializer;
import com.zyc.download4j.core.handler.DownloadHandler;
import com.zyc.download4j.core.handler.impl.CompressSourceHandler;
import com.zyc.download4j.core.handler.impl.CreateSourceHandler;
import com.zyc.download4j.core.handler.impl.LoadSourceHandler;
import com.zyc.download4j.core.handler.impl.WriteResponseHandler;
import com.zyc.download4j.core.load.DefaultSourceLoader;
import com.zyc.download4j.core.load.SourceLoader;
import com.zyc.download4j.core.log.ProgressCalculationLogger;
import com.zyc.download4j.core.log.StandardDownloadLogger;
import com.zyc.download4j.core.log.TimeSpentCalculationLogger;
import com.zyc.download4j.core.source.DefaultSourceFactoryAdapter;
import com.zyc.download4j.core.source.SourceFactory;
import com.zyc.download4j.core.source.SourceFactoryAdapter;
import com.zyc.download4j.core.source.classpath.ClassPathPrefixSourceFactory;
import com.zyc.download4j.core.source.classpath.ClassPathSourceFactory;
import com.zyc.download4j.core.source.file.FilePrefixSourceFactory;
import com.zyc.download4j.core.source.file.FileSourceFactory;
import com.zyc.download4j.core.source.file.UserHomeSourceFactory;
import com.zyc.download4j.core.source.http.HttpSourceFactory;
import com.zyc.download4j.core.source.multiple.ArraySourceFactory;
import com.zyc.download4j.core.source.multiple.CollectionSourceFactory;
import com.zyc.download4j.core.source.reactive.PublisherSourceFactory;
import com.zyc.download4j.core.source.reflect.ReflectionSourceFactory;
import com.zyc.download4j.core.source.self.SelfSourceFactory;
import com.zyc.download4j.core.source.text.TextSourceFactory;
import com.zyc.download4j.core.web.DownloadRequestProvider;
import com.zyc.download4j.core.web.DownloadResponseProvider;
import com.zyc.download4j.core.write.BufferedDownloadWriter;
import com.zyc.download4j.core.write.DefaultDownloadWriterAdapter;
import com.zyc.download4j.core.write.DownloadWriter;
import com.zyc.download4j.core.write.DownloadWriterAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 基础组件的配置。
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(DownloadConfiguration.class)
public class DownloadConceptCoreAutoConfiguration {

    @Bean
    public DownloadConfigurerInvoker downloadConfigurerInvoker(DownloadConfiguration configuration,
                                                               List<DownloadConfigurer> configurers) {
        return new DownloadConfigurerInvoker(configuration, configurers);
    }

    @Bean
    @ConditionalOnMissingBean
    public StandardDownloadLogger standardDownloadLogger(DownloadConfigurerInvoker invoker) {
        boolean enabled = invoker.getConfiguration().getLogger().getStandard().isEnabled() &&
                invoker.getConfiguration().getLogger().isEnabled();
        StandardDownloadLogger logger = new StandardDownloadLogger();
        logger.setEnabled(enabled);
        return logger;
    }

    @Bean
    @ConditionalOnMissingBean
    public TimeSpentCalculationLogger timeSpentCalculationLogger(DownloadConfigurerInvoker invoker) {
        boolean enabled = invoker.getConfiguration().getLogger().getTimeSpent().isEnabled() &&
                invoker.getConfiguration().getLogger().isEnabled();
        TimeSpentCalculationLogger logger = new TimeSpentCalculationLogger();
        logger.setEnabled(enabled);
        return logger;
    }

    @Bean
    @ConditionalOnMissingBean
    public ProgressCalculationLogger progressCalculationLogger(DownloadConfigurerInvoker invoker) {
        boolean enabled = invoker.getConfiguration().getLogger().getProgress().isEnabled() &&
                invoker.getConfiguration().getLogger().isEnabled();
        Duration duration = Duration.ofMillis(invoker.getConfiguration().getLogger().getProgress().getDuration());
        boolean percentage = invoker.getConfiguration().getLogger().getProgress().isPercentage();
        ProgressCalculationLogger logger = new ProgressCalculationLogger(duration, percentage);
        logger.setEnabled(enabled);
        return logger;
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadEventPublisher downloadEventPublisher(List<DownloadEventListener> listeners) {
        return new ApplicationDownloadEventPublisher(listeners);
    }

    @Bean
    public DownloadEventPublisherInitializer downloadEventPublisherInitializer(DownloadEventPublisher publisher) {
        return new DownloadEventPublisherInitializer(publisher);
    }

    @Bean
    public PublishContextEventInitializer publishContextEventInitializer() {
        return new PublishContextEventInitializer();
    }

    @Bean
    public PublishContextEventDestroyer publishContextEventDestroyer() {
        return new PublishContextEventDestroyer();
    }

    @Bean
    @ConditionalOnMissingBean
    public BufferedDownloadWriter bufferedDownloadWriter() {
        return new BufferedDownloadWriter();
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadWriterAdapter downloadWriterAdapter(List<DownloadWriter> writers) {
        return new DefaultDownloadWriterAdapter(writers);
    }

    @Bean
    @ConditionalOnMissingBean
    public CollectionSourceFactory collectionSourceFactory() {
        return new CollectionSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public ArraySourceFactory arraySourceFactory() {
        return new ArraySourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public SelfSourceFactory selfSourceFactory() {
        return new SelfSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public FileSourceFactory fileSourceFactory() {
        return new FileSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public FilePrefixSourceFactory filePrefixSourceFactory() {
        return new FilePrefixSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public UserHomeSourceFactory userHomeSourceFactory() {
        return new UserHomeSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public TextSourceFactory textSourceFactory() {
        return new TextSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClassPathSourceFactory classPathResourceSourceFactory() {
        return new ClassPathSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClassPathPrefixSourceFactory classPathPrefixSourceFactory() {
        return new ClassPathPrefixSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public HttpSourceFactory httpSourceFactory() {
        return new HttpSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public PublisherSourceFactory publisherSourceFactory() {
        return new PublisherSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public ReflectionSourceFactory reflectionSourceFactory() {
        return new ReflectionSourceFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public SourceFactoryAdapter sourceFactoryAdapter(List<SourceFactory> factories) {
        return new DefaultSourceFactoryAdapter(factories);
    }

    @Bean
    @ConditionalOnMissingBean
    public CacheNameGenerator cacheNameGenerator() {
        return new TimestampCacheNameGenerator();
    }

    @Bean
    public CacheNameGeneratorInitializer cacheNameGeneratorInitializer(CacheNameGenerator generator) {
        return new CacheNameGeneratorInitializer(generator);
    }

    @Bean
    @ConditionalOnMissingBean
    public ZipSourceCompressor zipSourceCompressor() {
        return new ZipSourceCompressor();
    }

    @Bean
    @ConditionalOnMissingBean
    public SourceCompressorAdapter sourceCompressorAdapter(List<SourceCompressor> compressors) {
        return new DefaultSourceCompressorAdapter(compressors);
    }

    @Bean
    @ConditionalOnMissingBean
    public CreateSourceHandler createSourceHandler(SourceFactoryAdapter adapter) {
        return new CreateSourceHandler(adapter);
    }

    @Bean
    @ConditionalOnMissingBean
    public SourceLoader sourceLoader() {
        return new DefaultSourceLoader();
    }

    @Bean
    @ConditionalOnMissingBean
    public LoadSourceHandler loadSourceHandler(SourceLoader loader) {
        return new LoadSourceHandler(loader);
    }

    @Bean
    @ConditionalOnMissingBean
    public CompressSourceHandler compressSourceHandler(SourceCompressorAdapter adapter) {
        return new CompressSourceHandler(adapter);
    }

    @Bean
    @ConditionalOnMissingBean
    public WriteResponseHandler writeResponseHandler(DownloadWriterAdapter adapter,
                                                     DownloadRequestProvider requestProvider,
                                                     DownloadResponseProvider responseProvider) {
        return new WriteResponseHandler(adapter, requestProvider, responseProvider);
    }

    @Bean
    @ConditionalOnMissingBean
    public DownloadContextFactory downloadContextFactory(List<DownloadContextInitializer> initializers,
                                                         List<DownloadContextDestroyer> destroyers) {
        return new DefaultDownloadContextFactory(initializers, destroyers);
    }

    @Bean
    public DownloadConcept downloadConcept(DownloadContextFactory factory,
                                           DownloadReturnInterceptor returnInterceptor,
                                           List<DownloadHandler> handlers) {
        return new ChainDownloadConcept(factory, returnInterceptor, handlers);
    }
}
