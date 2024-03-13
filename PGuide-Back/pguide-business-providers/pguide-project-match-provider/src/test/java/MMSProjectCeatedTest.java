import org.junit.jupiter.api.Test;
import org.pguide.api.user.redis.UserInfoRedisServer;
import org.pguide.common.redis.service.RedisService;
import org.pguide.project.match.PguideProjectMMSApplication;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author DKwms
 * @Date 2024/1/29 17:15
 * @description
 */
@SpringBootTest(classes = PguideProjectMMSApplication.class)
public class MMSProjectCeatedTest {

    @Autowired
    RedisService redisService;

    @Autowired
    UserInfoRedisServer userInfoRedisServer;

    @Test
    void testUserInfoInRedis(){
        String token = "PGUIDE_TOKEN_25ff9be3-ae56-4dad-9b3f-1c3f85af1637";
        System.out.println(redisService.getObj(token));
        UserInfoVo userInfo = userInfoRedisServer.getUserInfo("25ff9be3-ae56-4dad-9b3f-1c3f85af1637");
        System.out.println(userInfo);
    }
}
