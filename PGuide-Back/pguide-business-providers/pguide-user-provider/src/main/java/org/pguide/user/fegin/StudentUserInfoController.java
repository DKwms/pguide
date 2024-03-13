package org.pguide.user.fegin;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.pguide.api.user.feign.UserCenterGetStudentInfoClient;
import org.pguide.common.core.result.JsonResult;
import org.pguide.user.entity.UsercenterStudentInfo;
import org.pguide.user.service.impl.UsercenterStudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DKwms
 * @Date 2023/12/31 13:46
 * @description
 */


@RequestMapping
@RestController
public class StudentUserInfoController implements UserCenterGetStudentInfoClient {

    @Autowired
    UsercenterStudentInfoServiceImpl usercenterStudentInfoService;


    @Override
    public JsonResult<UsercenterStudentInfo> getStudentInfo(String id) {
        return JsonResult.success(usercenterStudentInfoService.getOne(Wrappers.<UsercenterStudentInfo>lambdaQuery().eq(UsercenterStudentInfo::getStudentId, id)));
    }


    @Override
    public JsonResult<UsercenterStudentInfo> getStudentWorkId(String student_id, String student_school, String student_academy) {
        return JsonResult.success(usercenterStudentInfoService
                .getOne(Wrappers.<UsercenterStudentInfo>lambdaQuery()
                        .eq(UsercenterStudentInfo::getWorkId, student_id)
                        .eq(UsercenterStudentInfo::getStudentSchool,student_school)
                        .eq(UsercenterStudentInfo::getStudentAcademy, student_academy)));
    }

    @Override
    public JsonResult<UsercenterStudentInfo> getStudentInfoByAccount(String account) {
        System.out.println(account);
        return JsonResult.success(usercenterStudentInfoService.getOne(Wrappers.<UsercenterStudentInfo>lambdaQuery().eq(UsercenterStudentInfo::getStudentAccount, account)));
    }

}
