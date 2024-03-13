package org.pguide.project.match.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.pguide.api.user.redis.UserInfoRedisServer;
import org.pguide.common.core.constant.ProjectConst;
import org.pguide.common.core.result.JsonResult;
import org.pguide.common.core.utils.UUIDUtil;
import org.pguide.common.security.annotation.UserAuth;
import org.pguide.project.match.controller.vo.ProjectCreatedVo;
import org.pguide.project.match.dict.ProjectDict;
import org.pguide.project.match.entity.*;
import org.pguide.project.match.service.impl.MmsProjectBelongInfoServiceImpl;
import org.pguide.project.match.service.impl.MmsProjectDetailInfoServiceImpl;
import org.pguide.project.match.service.impl.MmsProjectInfoServiceImpl;
import org.pguide.project.match.service.impl.MmsProjectMemberInfoServiceImpl;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author DKwms
 * @Date 2024/1/29 15:24
 * @description 除了第三阶段的数据会持久化，其他层的数据都储存在redis里面，如果15分钟内不操作，会删除。
 * 这里需要用到用户的token
 */


@RestController
@RequestMapping("/api/mms/create")
public class MMSProjectCreatedController {

    Integer MAX_PROJECT_NUM = 3;

    String PROJECT_CHECK01_LEVEL = "UNCHECK_01";

    @Autowired
    UserInfoRedisServer userInfoRedisServer;

    @Autowired
    MmsProjectMemberInfoServiceImpl mmsProjectMemberInfoService;

    @Autowired
    MmsProjectInfoServiceImpl mmsProjectInfoService;

    @Autowired
    MmsProjectBelongInfoServiceImpl mmsProjectBelongInfoService;

    @Autowired
    MmsProjectDetailInfoServiceImpl mmsProjectDetailInfoService;


    // 项目字典表
    @Autowired
    ProjectDict projectDict;

    @RequestMapping("/test")
    @UserAuth("*:student")
    public JsonResult<Void> test() {
        System.out.println("test方法正在执行");
        return JsonResult.success("pass");
    }


    /**
     * 检测用户项目是否到达上限
     * <br>
     * 在进入项目创建页时加载
     * 判断当前用户的项目创建数量
     */
    @RequestMapping("/check/max")
    @UserAuth("*:student")
    public JsonResult<Void> checkIfMax(HttpServletRequest request) {
        UserInfoVo userInfo = userInfoRedisServer.getUserInfo(request);
        // 获取用户id
        Integer userId = userInfo.getUserId();

        // 判断用户类型
        String userType = userInfo.getUserType();

        // 2、检查用户所拥有的项目 mysql
        List<MmsProjectMemberInfo> hisProject = mmsProjectMemberInfoService.list(Wrappers.<MmsProjectMemberInfo>lambdaQuery()
                .eq(MmsProjectMemberInfo::getMemberId, userId));

        // 判断当前用户是否可以继续创建项目
        /**
         * 这里是包括了用户拥有和创建的项目，也就是用户的所有项目和。
         * 而不是用户作为队长或者组长的项目
         */
        if(hisProject.size()>=MAX_PROJECT_NUM){ return JsonResult.error("超过项目创建上限"); }

        return JsonResult.success();
    }


    // 项目类型判断
    /**
     * 自由项目 | 非自由项目<br>
     * 一、定义
     * 自由项目： 不归属学校管理，属于学生自创，审核发表无需通过相应学校审核，所属及管理权属于创建者
     * 非自由项目：归属学校管理，创建发布需要学校同意和管辖，学校有审核权
     *
     * 二、审核流程
     * 自由项目，通过平台审核后直接上限
     * 非自由项目，审核权给相关校方进行审核，平台可被校方委托审核
     *
     */

    /**
     * 自由项目提交审核,
     * 存储相关信息到mms库中，通知负责人审核项目
     */
    @PostMapping("/student/project/check")
    @UserAuth("*:student")
    @Transactional
    public JsonResult<Void> checkBySys(@RequestBody ProjectCreatedVo projectCreatedVo,HttpServletRequest request) {
        if(projectCreatedVo==null){
            return JsonResult.error("请求体为空");
        }
        UserInfoVo userInfo = userInfoRedisServer.getUserInfo(request);

        //检查用户创建项目上限
        Integer userId = userInfo.getUserId();
        long userCreatedProjectNums = mmsProjectMemberInfoService.count(
                Wrappers.<MmsProjectMemberInfo>lambdaQuery()
                        .eq(MmsProjectMemberInfo::getMemberId,userId)
        );
        if(userCreatedProjectNums>=MAX_PROJECT_NUM){
            return JsonResult.error("该用户创建项目数量已达上限");
        }

        // 项目名重名检测
        MmsProjectInfo info = mmsProjectInfoService.getOne(Wrappers.<MmsProjectInfo>lambdaQuery()
                .eq(MmsProjectInfo::getProjectName, projectCreatedVo.getName()));

        if(info!=null) { return JsonResult.error("项目名已存在"); }


        //TODO 敏感词检查


        // 字典表
        Map<String, Integer> projectStatusMapDict = projectDict.PROJECT_STATUS_MAP_DICT;
        List<MmsProjectTypeInfo> projectTypeDict = projectDict.PROJECT_TYPE_DICT;


        // 项目类型检查
        /**
         * 对应的是 mms_project_type_info 表，
         * projectTypeName ： 项目小类，对应的也是竞赛偏好，只支持一个，这个是大方向（数学建模，创新创业，创新实验...）
         * ProjectTypeLevel ： 项目等级，标记自由项目还是非自由项目
         */
        List<MmsProjectTypeInfo> projectTypeObj = projectTypeDict.stream().filter(
                e ->
                        e.getProjectTypeName().equals(projectCreatedVo.getType()) // 项目小类
        ).filter(
                e ->
                        e.getProjectTypeLevel().equals(projectCreatedVo.getTypeLevel()) // free | unfree
        ).collect(Collectors.toList());

        if (projectTypeObj.size()!=1){
            return JsonResult.error("项目竞赛类别有误");
        }

        // 项目创建
        int projectId = UUIDUtil.getRandomIntUUID();
        MmsProjectInfo projectInfo = MmsProjectInfo.builder()
                // uuid
                .projectId(projectId)
                .projectName(projectCreatedVo.getName())
                .projectOpenLevel(projectCreatedVo.getOpenLevel())
                .projectTypeId(projectTypeObj.get(0).getProjectTypeId())
                .projectSubjectType(projectCreatedVo.getSubject())
                .projectStatusId(projectStatusMapDict.get(PROJECT_CHECK01_LEVEL))
                .build();

        // 详情信息
        MmsProjectDetailInfo projectDetailInfo = MmsProjectDetailInfo.builder()
                .projectId(projectId)
                .projectIntroduction(projectCreatedVo.getDetail())
                .build();


        //项目所属
            // 用户
        MmsProjectMemberInfo mmsProjectMemberInfo = MmsProjectMemberInfo.builder()
                .projectId(projectId)
                .memberTypeId(ProjectConst.memberTypeConst.CREATOR_STRING_ID)
                .memberId(userInfo.getUserId()).build();
            // 学校
            //TODO 这里需要一份系统的学校和学科组织的字典表,from usercenter 和redis，暂时写1
        MmsProjectBelongInfo mmsProjectBelongInfo = MmsProjectBelongInfo.builder()
                .projectId(projectId)
                .academyId(1)
                .schoolId(1)
                .orgId(1)
                .build();


        //存储
        // TODO 后面mq异步解耦
        mmsProjectMemberInfoService.save(mmsProjectMemberInfo);
        mmsProjectInfoService.save(projectInfo);
        mmsProjectBelongInfoService.save(mmsProjectBelongInfo);
        mmsProjectDetailInfoService.save(projectDetailInfo);

        //TODO 异步发起通知，通知平台负责人发起审核


        return JsonResult.success("项目提交成功");
    }

    /**
     * 非自由项目提交审核
     */
    @RequestMapping("/check/unfree")
    @UserAuth("*:student")
    public JsonResult<Void> checkBy(){

        //TODO 学校学院检查

        return JsonResult.success();
    }



}
