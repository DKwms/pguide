package mybatis;

import org.junit.jupiter.api.Test;


import org.pguide.index.info.service.impl.IndexCarouselImgServiceImpl;
import org.pguide.provider.index.info.IndexInfoProviderApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author DKwms
 * @Date 2023/12/2 17:00
 * @description
 */
@SpringBootTest(classes = IndexInfoProviderApplication.class)
public class BaseMybatisTest {

    @Autowired
    IndexCarouselImgServiceImpl indexCarouselImgService;

    @Test
    public void testMybatis(){
        indexCarouselImgService.list();
    }
}
