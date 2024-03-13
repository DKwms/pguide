package org.pguide.auth.manage.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.pguide.auth.manage.common.AuthCenterRedisKey;
import org.pguide.auth.manage.controller.vo.ChangeUserVo;
import org.pguide.auth.manage.entity.SysAuthInfo;
import org.pguide.auth.manage.service.impl.SysAuthInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/5 18:21
 * @description  更新mysql中开发系统状态，同时通知所有Auth鉴权网关进行更新缓存(MQ)
 */

@RestController
@Slf4j
@RequestMapping("/auth/system/info")
//用户中心数据源
@DataSource(value = DataSourceType.USER)
public class SubSystemStrategyEntityRefreshController {

    @Autowired
    SysAuthInfoServiceImpl sysAuthInfoService;

    @Autowired
    RedisCache redisCache;

    /**
     * 系统数据列表
     * @return
     *
     */
    @GetMapping("/list")
    public AjaxResult refresh(){
        //TODO 后序限制返回
        List<SysAuthInfo> list = sysAuthInfoService.list();
        return AjaxResult.success(list);
    }

    /**
     * 显示当前系统开放状态
     * @return
     */
    @GetMapping("/refresh")
    public AjaxResult showSystemStatus(){
        /**
         * 获取redis缓存，检查更新，mysql从同步
         */

        // 检查开放系统

        List<SysAuthInfo> list = sysAuthInfoService.list();

        // list of systemName
        String PGuide_REDIS_PRE = AuthCenterRedisKey.PGUIDE_REDIS_SYS_NAME_PRE;
        ArrayList<String> openSys = new ArrayList<>();

        for (SysAuthInfo sysAuthInfo : list) {
            if("open".equals(sysAuthInfo.getSysType())){
                openSys.add(sysAuthInfo.getSysName());
                // 更新系统开放用户
                redisCache.setCacheObject(PGuide_REDIS_PRE + sysAuthInfo.getSysName(),sysAuthInfo.getSysUser());
            }else{
                // 系统关闭，清除相关缓存
                boolean b = redisCache.deleteObject(PGuide_REDIS_PRE + sysAuthInfo.getSysName());
                if(!b) log.warn("缓存删除失败");
            }
        }

        // 更新系统列表
        redisCache.setCacheList(AuthCenterRedisKey.PGUIDE_REDIS_SYS_NAME_LIST,openSys);

        //TODO 通知鉴权中心更新系统缓存，RabbitMQ

        return AjaxResult.success();
    }

    /**
     * 全量更新
     * @param changeUserVo
     * @return
     */
    @PostMapping("/change/user")
    public AjaxResult changeUser(@RequestBody ChangeUserVo changeUserVo){
        if(changeUserVo == null) {
            log.error("修改信息异常");
            return AjaxResult.error();
        }

        SysAuthInfo aimOne = sysAuthInfoService.getOne(Wrappers.<SysAuthInfo>lambdaQuery()
                .eq(SysAuthInfo::getSysName, changeUserVo.getSysName()));

        if(aimOne==null){
            SysAuthInfo open = SysAuthInfo.builder()
                    .sysName(changeUserVo.getSysName())
                    .sysUser(changeUserVo.getSysUser())
                    .sysType("open")
                    .build();

            // 全量
            sysAuthInfoService.save(open);
            return AjaxResult.success("更新成功！新增sys_auth数据");
        }

        aimOne.setSysUser(changeUserVo.getSysUser());
        sysAuthInfoService.updateById(aimOne);

        return AjaxResult.success();
    }



}
