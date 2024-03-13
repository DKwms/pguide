
import org.junit.jupiter.api.Test;
import org.pguide.auth.AuthApplication;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.auth.service.template.impl.SubSystemLoginTemplateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Author DKwms
 * @Date 2024 01 2024/1/5 16 06
 */

//@SpringBootTest(classes= AuthApplication.class)
@SpringBootTest(classes = AuthApplication.class)
public class TestSubSystemEntityWithRedis {

    @Autowired
    SubSystemLoginTemplateImpl subSystemLoginTemplate;


    @Test

    void testSSLTI(){
        LoginBody loginBody = LoginBody.builder().account("student").password("student").build();

        boolean match = subSystemLoginTemplate.match("pguide", "student", loginBody);

        System.out.println(match);
    }
}
