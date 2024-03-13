package org.pguide.api.user.feign;

import org.pguide.common.core.result.JsonResult;
import org.pguide.user.entity.UsercenterStudentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DKwms
 * @Date 2023/12/31 13:55
 * @description
 */

@FeignClient(value = "pguide-usercenter",contextId = "UserCenterGetStudentInfoClient")
public interface UserCenterGetStudentInfoClient {

    /**
     * 返回指定id学生的信息
     * @return
     */
    @GetMapping("/api/usercenter/student/info/byid")
    JsonResult<UsercenterStudentInfo> getStudentInfo(@RequestParam("id") String id);


    /**
     * 返回指定学生信息
     * 通过学号 学院和学校信息
     * @param student_id
     * @param student_school
     * @param student_academy
     * @return
     */
    @GetMapping("/api/usercenter/student/info/byinfo")
    JsonResult<UsercenterStudentInfo> getStudentWorkId(@RequestParam("/student_id") String student_id, @RequestParam("student_school") String student_school, @RequestParam("student_academy") String student_academy);

    /**
     * 返回指定account学生信息
     * 用于密码校验，
     * 这里的账户是老师自定义的注册账户
     * TODO 优化vo
     * @param account 学生自定义账户
     * @return
     */
    @GetMapping("/api/usercenter/student/info/byaccount")
    JsonResult<UsercenterStudentInfo> getStudentInfoByAccount(@RequestParam("account") String account);
}
