package org.pguide.api.user.feign;

import org.pguide.common.core.result.JsonResult;
import org.pguide.user.entity.UsercenterTeacherInfo;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DKwms
 * @Date 2024/1/2 14:03
 * @description
 */

@FeignClient(value = "pguide-usercenter",contextId = "PGuide-UserCenter")
public interface UserCenterGetTeacherInfoClient {

    /**
     * 返回指定id老师的信息
     * 系统内部快速获取老师信息
     * @return
     */
    @GetMapping("/api/usercenter/teacher/info/byid")
    JsonResult<UsercenterTeacherInfo> getTeacherInfo(@RequestParam("id") String id);


    /**
     * 返回指定工号老师信息
     * 用于密码校验，
     * @param work_id           学号
     * @param teacher_unit      单位(学校)
     * @param teacher_academy   学院
     * @return
     */
    @GetMapping("/api/usercenter/teacher/info/byinfo")
    JsonResult<UsercenterTeacherInfo> getTeacherWorkId(@RequestParam("work_id") String work_id, @RequestParam("teacher_unit") String teacher_unit, @RequestParam("teacher_academy") String teacher_academy);

    /**
     * 返回指定account老师信息
     * 这里的账户是老师自定义的注册账户
     * TODO 优化vo
     * @param account
     * @return
     */
    @GetMapping("/api/usercenter/teacher/info/byaccount")
    JsonResult<UsercenterTeacherInfo> getTeacherInfoByAccount(@RequestParam("account") String account);

    /**
     * 通过学生信息获取id
     * @param studentId
     * @return
     */
    @GetMapping("/api/usercenter/teacher/info/vo")
    JsonResult<UserInfoVo> getUserInfoVoById(@RequestParam("id") String studentId);


}
