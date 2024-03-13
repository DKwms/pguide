
import org.junit.jupiter.api.Test;
import org.pguide.api.user.redis.SysUserRedisServer;
import org.pguide.auth.AuthApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author DKwms
 * @Date 2024/1/30 17:10
 * @description
 */

@SpringBootTest(classes = AuthApplication.class)
public class SysUserRedisServerTest {

    @Autowired
    SysUserRedisServer sysUserRedisServer;


    // test get the data from redis
    @Test
    void testGet(){
        Map<String, List<String>> systemTypeUserMap = sysUserRedisServer.getSystemTypeUserMap();

        systemTypeUserMap.entrySet().forEach(System.out::println);
    }

    // test set data to redis from db
    //@Test
    //void testSet(){
    //    sysUserRedisServer.setSystemTypeUserMapFromMysql();
    //}
}
