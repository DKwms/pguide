import com.ruoyi.RuoYiApplication;
import org.junit.jupiter.api.Test;
import org.pguide.mms.manage.controller.publish.es.domain.dto.ProjectInfo;
import org.pguide.mms.manage.controller.publish.vo.ProjectPublishVo;
import org.pguide.mms.manage.mapper.MmsProjectInfoMapper;
import org.pguide.mms.manage.service.impl.MmsProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/2/18 21:13
 * @description
 */

@SpringBootTest(classes = RuoYiApplication.class)
public class PublishVoTest {

    @Autowired
    MmsProjectInfoMapper mmsProjectInfoMapper;

    @Autowired
    MmsProjectInfoServiceImpl mmsProjectInfoService;


    @Test
    void test(){
        List<ProjectPublishVo> projectPublishVos = mmsProjectInfoMapper.selectPublishVo(new ProjectPublishVo());

        projectPublishVos.forEach(System.out::println);
    }

    @Test
    void testProjectInfo(){
        ProjectInfo projectInfo = mmsProjectInfoService.selectMmsProjectInfoToEs("spd");
        System.out.println(projectInfo);

    }
}
