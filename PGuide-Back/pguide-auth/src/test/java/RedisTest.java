import org.junit.jupiter.api.Test;
import org.pguide.auth.AuthApplication;
import org.pguide.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/20 20:40
 * @description
 */

@SpringBootTest(classes = AuthApplication.class)
public class RedisTest {

    @Autowired
    RedisService redisService;

    @Test
    void getIt(){
        redisService.setObj("a","b");
        //List<Object> list = redisService.getList(AuthRedisKey.PGUIDE_REDIS_SYS_NAME_LIST);
        //
        //list.forEach(System.out::println);
        //System.out.println(list.size());
        //
        //System.out.println("==================");
        //System.out.println(redisService.getObj("a"));
    }

}
