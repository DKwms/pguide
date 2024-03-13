package org.pguide.auth.manage.controller;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.pguide.auth.manage.entity.SysAuthInfo;
import org.pguide.auth.manage.service.ISysAuthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登录权限控制Controller
 * 
 * @author DKwms
 * @date 2024-01-20
 */
@RestController
@RequestMapping("/auth/system/login/control")
@Slf4j
public class SysAuthInfoController extends BaseController
{
    @Autowired
    private ISysAuthInfoService sysAuthInfoService;

    /**
     * 查询登录权限控制列表
     */
    @PreAuthorize("@ss.hasPermi('auth:system/login/control:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysAuthInfo sysAuthInfo)
    {
        startPage();
        List<SysAuthInfo> list = sysAuthInfoService.selectSysAuthInfoList(sysAuthInfo);
        return getDataTable(list);
    }

    /**
     * 导出登录权限控制列表
     */
    @PreAuthorize("@ss.hasPermi('auth:system/login/control:export')")
    @Log(title = "登录权限控制", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysAuthInfo sysAuthInfo)
    {
        List<SysAuthInfo> list = sysAuthInfoService.selectSysAuthInfoList(sysAuthInfo);
        ExcelUtil<SysAuthInfo> util = new ExcelUtil<SysAuthInfo>(SysAuthInfo.class);
        util.exportExcel(response, list, "登录权限控制数据");
    }

    /**
     * 获取登录权限控制详细信息
     */
    @PreAuthorize("@ss.hasPermi('auth:system/login/control:query')")
    @GetMapping(value = "/{sysId}")
    public AjaxResult getInfo(@PathVariable("sysId") Long sysId)
    {
        return success(sysAuthInfoService.selectSysAuthInfoBySysId(sysId));
    }

    /**
     * 新增登录权限控制
     */
    @PreAuthorize("@ss.hasPermi('auth:system/login/control:add')")
    @Log(title = "登录权限控制", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysAuthInfo sysAuthInfo)
    {
        return toAjax(sysAuthInfoService.insertSysAuthInfo(sysAuthInfo));
    }

    /**
     * 修改登录权限控制
     */
    @PreAuthorize("@ss.hasPermi('auth:system/login/control:edit')")
    @Log(title = "登录权限控制", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysAuthInfo sysAuthInfo)
    {
        return toAjax(sysAuthInfoService.updateSysAuthInfo(sysAuthInfo));
    }

    /**
     * 删除登录权限控制
     */
    @PreAuthorize("@ss.hasPermi('auth:system/login/control:remove')")
    @Log(title = "登录权限控制", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sysIds}")
    public AjaxResult remove(@PathVariable Long[] sysIds)
    {
        return toAjax(sysAuthInfoService.deleteSysAuthInfoBySysIds(sysIds));
    }
}
