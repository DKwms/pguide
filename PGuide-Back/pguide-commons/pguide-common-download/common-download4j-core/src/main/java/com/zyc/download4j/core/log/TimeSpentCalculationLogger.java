package com.zyc.download4j.core.log;

import com.zyc.download4j.core.context.AfterContextDestroyedEvent;
import com.zyc.download4j.core.context.AfterContextInitializedEvent;
import com.zyc.download4j.core.context.DownloadContext;
import org.springframework.util.StopWatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 时间计算日志。
 */
public class TimeSpentCalculationLogger extends DownloadLogger {

    private final Map<String, StopWatch> stopWatchMap = new ConcurrentHashMap<>();

    @Override
    public void logOnEvent(Object event) {
        if (event instanceof AfterContextInitializedEvent) {
            StopWatch watch = new StopWatch();
            watch.start();
            stopWatchMap.put(((AfterContextInitializedEvent) event).getContext().getId(), watch);
        } else if (event instanceof AfterContextDestroyedEvent) {
            DownloadContext context = ((AfterContextDestroyedEvent) event).getContext();
            String id = context.getId();
            StopWatch watch = stopWatchMap.remove(id);
            if (watch != null) {
                watch.stop();
                double seconds = watch.getTotalTimeSeconds();
                log(context, "Time spent " + seconds + " s");
            }
        }
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE - 1;
    }
}
