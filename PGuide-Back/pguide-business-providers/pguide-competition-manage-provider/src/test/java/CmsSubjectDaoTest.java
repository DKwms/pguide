import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.pguide.competition.manage.PguideCMSManageApplication;
import org.pguide.competition.manage.service.impl.CmsSubjectDictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author DKwms
 * @Date 2024/1/17 10:28
 * @description
 */

@SpringBootTest(classes = PguideCMSManageApplication.class)
@Slf4j
public class CmsSubjectDaoTest {

    @Autowired
    CmsSubjectDictServiceImpl cmsSubjectDictService;

    @Test
    void testTree(){
        cmsSubjectDictService.getSubjectTree();
    }
}
