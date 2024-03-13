package com.zyc.download4j.core.context;

import com.zyc.download4j.core.options.DownloadOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * {@link DownloadContext} 的默认实现。
 */
@SuppressWarnings("unchecked")
public class DefaultDownloadContext extends AbstractDownloadContext {

    private final Map<Object, Object> map = new HashMap<>();

    public DefaultDownloadContext(String id, DownloadOptions options) {
        super(id, options);
    }

    @Override
    public void set(Object key, Object value) {
        map.put(key, value);
    }


    @Override
    public <T> T get(Object key) {
        return (T) map.get(key);
    }

    @Override
    public boolean contains(Object key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(Object key) {
        map.remove(key);
    }

    @Override
    public void destroy() {
        super.destroy();
        map.clear();
    }
}
