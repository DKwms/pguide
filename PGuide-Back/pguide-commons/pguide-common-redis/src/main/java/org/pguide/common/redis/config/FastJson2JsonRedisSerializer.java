package org.pguide.common.redis.config;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * Redis使用FastJson序列化
 * 
 * @author DKwms
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T>
{
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz)
    {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException
    {
        if (t == null)
        {
            return new byte[0];
        }
        //return JSON.toJSONString(t).getBytes(DEFAULT_CHARSET);
        return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException
    {
        if (bytes == null || bytes.length <= 0)
        {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        return JSON.parseObject(str, clazz, JSONReader.Feature.SupportAutoType);
    }

    public static void main(String[] args) {
        A a = new A();

        // 这里的 JSONWriter.Feature.WriteClassName 会写入一个type属性进去，跨系统很麻烦
        // 因为不同系统的包不一定在同一个位置，还是后期自己序列化比较方便
        //byte[] bytes = JSON.toJSONString(a, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
        byte[] bytes = JSON.toJSONString(a).getBytes(DEFAULT_CHARSET);

        String str = new String(bytes, DEFAULT_CHARSET);
        System.out.println(str);

        Object o = JSON.parseObject(str, Object.class, JSONReader.Feature.SupportAutoType);

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class A{
    int a = 1;
    int b = 2;
}
