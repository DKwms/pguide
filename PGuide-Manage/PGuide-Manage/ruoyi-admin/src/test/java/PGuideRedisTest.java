import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/5 19:34
 * @description
 */

@SpringBootTest(classes = RuoYiApplication.class)
@Slf4j
//用户中心数据源
@DataSource(value = DataSourceType.USER)
public class PGuideRedisTest {

    @Autowired
    RedisCache redisCache;


    @Test
    void getTest(){
        redisCache.setCacheList("PRE_TEST_KEY",new ArrayList<String>(){{
            this.add("test1");
            this.add("test1");
            this.add("test1");
        }});

        log.info("save sc");
    }

    @Test
    void checkTest(){
        synchronized (this){
            List<String> cacheList = redisCache.getCacheList("PRE_TEST_KEY");
            cacheList.forEach(e->{
                log.info(e);
            });
        }

    }
}
