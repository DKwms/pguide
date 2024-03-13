package org.pguide.mms.manage.controller.publish;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.uuid.UUID;
import org.aspectj.weaver.loadtime.Aj;
import org.pguide.mms.manage.controller.publish.es.domain.dto.ProjectInfo;
import org.pguide.mms.manage.controller.publish.es.service.impl.ESProjectInfoServiceImpl;
import org.pguide.mms.manage.controller.publish.es.utils.UUIDUtil;
import org.pguide.mms.manage.controller.publish.vo.ProjectPublishUpdatedVo;
import org.pguide.mms.manage.controller.publish.vo.ProjectPublishVo;
import org.pguide.mms.manage.mapper.MmsProjectInfoMapper;
import org.pguide.mms.manage.service.impl.MmsProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/22 21:27
 * @description
 * 项目发布
 */

// TODO 日志
@RequestMapping("/api/mms/publish")
@RestController
public class ProjectPublishController extends BaseController {

    Integer SYS_CHECKED_ID = 2;

    Integer SYS_PUBLISH_ID = 4;

    Integer SYS_STOP_PUBLISH = 5;

    Integer SYS_UNPASS_ID = 6;

    @Autowired
    MmsProjectInfoMapper mmsProjectInfoMapper;

    @Autowired
    MmsProjectInfoServiceImpl mmsProjectInfoService;

    @Autowired
    ESProjectInfoServiceImpl service;

    // 发送自由项目待审核列表
    // 默认第一次搜索的是通过的
    @GetMapping("/list")
    public TableDataInfo getPorjectInfo(ProjectPublishVo projectPublishVo){
        startPage();
        List<ProjectPublishVo> projectPublishVos = mmsProjectInfoMapper.selectPublishVo(projectPublishVo);
        // 拼接学校学院
        projectPublishVos.forEach(e->{
            Integer schoolId = e.getProjectSchoolId();
            Integer projectAcademyId = e.getProjectAcademyId();
            // TODO 查询对应的学号和学校（字典表，内存中）
            e.setProjectAcademy("医学信息学院");
            e.setProjectSchool("重庆医科大学");
        });
        return getDataTable(projectPublishVos);
    }

    /**
     * TODO 鉴权
     * 打回
     */
    @PostMapping("/sys/uppass")
    public AjaxResult unpassTheProject(@RequestBody ProjectPublishUpdatedVo projectPublishUpdatedVo){
        projectPublishUpdatedVo.setStatus_id(SYS_UNPASS_ID);
        mmsProjectInfoService.updateProjectInfoByName(projectPublishUpdatedVo);
        return AjaxResult.success("修改成功");
    }
    /**
     * TODO 权限
     * 系统审核通过
     * @return
     */
    @PostMapping("/sys/checked")
    public AjaxResult checkedTheProject(@RequestBody ProjectPublishUpdatedVo projectPublishUpdatedVo){
        projectPublishUpdatedVo.setStatus_id(SYS_CHECKED_ID);
        mmsProjectInfoService.updateProjectInfoByName(projectPublishUpdatedVo);
        return AjaxResult.success("修改成功");
    }


    /**
     * TODO 权限
     * TODO 待测试
     * 系统发布
     * @return
     */
    @PostMapping("/sys/publish")
    public AjaxResult pastTheProject(@RequestBody ProjectPublishUpdatedVo projectPublishUpdatedVo){
        //状态更换
        projectPublishUpdatedVo.setStatus_id(SYS_PUBLISH_ID);
        mmsProjectInfoService.updateProjectInfoByName(projectPublishUpdatedVo);

        // 生成项目信息
        ProjectInfo projectInfo = mmsProjectInfoService.selectMmsProjectInfoToEs(projectPublishUpdatedVo.getProjectName());

        // 项目信息发布
        service.addObj(projectInfo, UUIDUtil.getFastIntUUID());

        return AjaxResult.success("修改成功");
    }

    /**
     * TODO 权限
     * 系统停止发布项目
     */
    @PostMapping("/sys/stop")
    public AjaxResult stopPublishTheProject(@RequestBody ProjectPublishUpdatedVo projectPublishUpdatedVo){
        projectPublishUpdatedVo.setStatus_id(SYS_STOP_PUBLISH);
        mmsProjectInfoService.updateProjectInfoByName(projectPublishUpdatedVo);
        return AjaxResult.success("修改成功");
    }





}
