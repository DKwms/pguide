package com.zyc.download4j.core.source.reflect.conversion;

import com.zyc.download4j.core.exception.DownloadException;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 值类型转换的帮助类。
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class ValueConversion {

    private static final ValueConversion instance = new ValueConversion(StringToCharsetValueConvertor.getInstance());

    public static ValueConversion getInstance() {
        return instance;
    }

    private final Collection<ValueConvertor> convertors = new CopyOnWriteArrayList<>();

    private ValueConversion(ValueConvertor... convertors) {
        register(convertors);
    }

    public void register(Collection<? extends ValueConvertor> convertors) {
        if (convertors == null) {
            throw new NullPointerException("Value convertors is null");
        }
        this.convertors.addAll(convertors);
    }

    public void register(ValueConvertor... convertors) {
        register(Arrays.asList(convertors));
    }

    public Object convert(Object value, Class<?> type) {
        if (value == null) {
            return null;
        }
        for (ValueConvertor convertor : convertors) {
            if (convertor.support(value, type)) {
                return convertor.convert(value);
            }
        }
        throw new DownloadException("Value " + value + " cannot format to " + type);
    }
}
