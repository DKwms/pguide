import com.pguide.project.controller.dto.ProjectTaskDto;
import com.pguide.project.domain.ProjectTask;
import com.pguide.project.service.impl.ProjectTaskServiceImpl;
import com.ruoyi.RuoYiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author DKwms
 * @Date 2023 11 2023/11/10 08 57
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class TestTaskDto {

    @Autowired
    ProjectTaskServiceImpl projectTaskService;

    @Test
    public void test(){
        List<ProjectTaskDto> projectTaskDto = projectTaskService.getProjectTaskDto((long) 1);

        projectTaskDto.forEach(System.out::println);


    }
}
