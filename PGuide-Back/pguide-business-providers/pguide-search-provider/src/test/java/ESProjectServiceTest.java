import org.junit.jupiter.api.Test;
import org.pguide.api.search.domain.bo.CptInfo;
import org.pguide.api.search.domain.bo.Member;
import org.pguide.api.search.domain.bo.Needs;
import org.pguide.api.search.domain.dto.ProjectInfo;
import org.pguide.common.core.result.JsonResult;
import org.pguide.search.PguideSearchApplication;
import org.pguide.search.web.projectinfo.service.impl.ESProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/23 11:51
 * @description
 */


@SpringBootTest(classes = PguideSearchApplication.class)
public class ESProjectServiceTest {

    @Autowired
    ESProjectInfoServiceImpl service;
    //
    //void testDoc(){
    //    service.addNewObj()
    //}

    /**
     * 新增检查
     */

    @Test
    public void generateTestData() {
        ProjectInfo projectInfo = createProjectInfo(11);
        service.addObj(projectInfo,10+100);
    }

    private ProjectInfo createProjectInfo(int index) {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setProjectName("Project" + index);
        projectInfo.setSubject("Subject" + index);
        projectInfo.setMember(createMembers(index));
        projectInfo.setSchool("School" + index);
        projectInfo.setAcademy("Academy" + index);
        projectInfo.setCity("City" + index);
        projectInfo.setNeeds(createNeeds(index));
        projectInfo.setOpenLevel("Level" + index);
        projectInfo.setCptInfo(createCptInfo(index));
        projectInfo.setCoin(index);
        return projectInfo;
    }

    private List<Member> createMembers(int index) {
        List<Member> members = new ArrayList<>();
        Member member = new Member();
        member.setMemberId(index);
        member.setMemberType("Type" + index);
        member.setMemberName("Name" + index);
        members.add(member);
        return members;
    }

    private Needs createNeeds(int index) {
        Needs needs = new Needs();
        needs.setNeedId(index);
        needs.setNeedTypeName("Type" + index);
        needs.setNeedInfo("Info" + index);
        return needs;
    }

    private List<CptInfo> createCptInfo(int index) {
        List<CptInfo> cptInfoList = new ArrayList<>();
        CptInfo cptInfo = new CptInfo();
        cptInfo.setCptName("CptName" + index);
        cptInfo.setCptType("CptType" + index);
        cptInfoList.add(cptInfo);
        return cptInfoList;
    }

    /**
     * 搜索检查
     */

    @Test
    public void searchBySearchInfo(){
        JsonResult<List<ProjectInfo>> cptName11 = service.getAimObj("CptName11");
    }
}
