import com.pguide.project.controller.vo.ProjectLogVo;
import com.pguide.project.mapper.ProjectLogDetailMapper;
import com.pguide.project.mapper.ProjectLogTopMapper;
import com.ruoyi.RuoYiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/10/8 18:09
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class TestDaoLog {

    @Autowired
    ProjectLogDetailMapper projectLogDetailMapper;

    @Autowired
    ProjectLogTopMapper projectLogTopMapper;

    @Test
    public void testAll(){
        projectLogTopMapper.selectLogPage(new ProjectLogVo("DKwms","大标题",2L,0),4).forEach(System.out::println);
    }

}
