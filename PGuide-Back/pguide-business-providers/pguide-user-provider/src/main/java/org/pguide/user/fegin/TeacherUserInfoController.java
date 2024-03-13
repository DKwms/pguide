package org.pguide.user.fegin;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.pguide.api.user.feign.UserCenterGetTeacherInfoClient;
import org.pguide.common.core.result.JsonResult;
import org.pguide.user.entity.UsercenterTeacherInfo;
import org.pguide.user.entity.vo.UserInfoVo;
import org.pguide.user.service.UsercenterTeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DKwms
 * @Date 2024/1/2 14:02
 * @description
 */

@RequestMapping
@RestController
public class TeacherUserInfoController implements UserCenterGetTeacherInfoClient {

    @Autowired
    UsercenterTeacherInfoService usercenterTeacherInfoService;

    @Override
    public JsonResult<UsercenterTeacherInfo> getTeacherInfo(String id) {
        UsercenterTeacherInfo Teacher = usercenterTeacherInfoService.getOne(Wrappers.<UsercenterTeacherInfo>lambdaQuery().eq(UsercenterTeacherInfo::getTeacherId, id));
        return JsonResult.success(Teacher);
    }

    @Override
    public JsonResult<UsercenterTeacherInfo> getTeacherWorkId(String work_id, String teacher_unit, String teacher_academy) {
        return JsonResult.success(usercenterTeacherInfoService
                .getOne(Wrappers.<UsercenterTeacherInfo>lambdaQuery()
                        .eq(UsercenterTeacherInfo::getWorkId, work_id)
                        .eq(UsercenterTeacherInfo::getTeacherUnit,teacher_unit)
                        .eq(UsercenterTeacherInfo::getTeacherAcademy, teacher_academy)));
    }

    @Override
    public JsonResult<UsercenterTeacherInfo> getTeacherInfoByAccount(String account) {
        System.out.println(account);
        return JsonResult.success(usercenterTeacherInfoService.getOne(Wrappers.<UsercenterTeacherInfo>lambdaQuery().eq(UsercenterTeacherInfo::getTeacherAccount, account)));
    }

    @Override
    public JsonResult<UserInfoVo> getUserInfoVoById(String studentId) {
        return null;
    }
}
