package org.pguide.user.manage.controller;


import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.pguide.user.manage.entity.UsercenterTeacherInfo;
import org.pguide.user.manage.service.IUsercenterTeacherInfoService;
import org.pguide.user.manage.service.impl.UsercenterTeacherInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author dkwms
 * @date 2024-01-02
 */
@RestController
@RequestMapping("/project/info/teacher")
@DataSource(value= DataSourceType.USER)
public class UsercenterTeacherInfoController extends BaseController
{

    @Autowired
    private UsercenterTeacherInfoServiceImpl usercenterTeacherInfoService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(UsercenterTeacherInfo usercenterTeacherInfo)
    {
        startPage();
        List<UsercenterTeacherInfo> list = usercenterTeacherInfoService.selectUsercenterTeacherInfoList(usercenterTeacherInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:info:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UsercenterTeacherInfo usercenterTeacherInfo)
    {
        List<UsercenterTeacherInfo> list = usercenterTeacherInfoService.selectUsercenterTeacherInfoList(usercenterTeacherInfo);
        ExcelUtil<UsercenterTeacherInfo> util = new ExcelUtil<UsercenterTeacherInfo>(UsercenterTeacherInfo.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:info:query')")
    @GetMapping(value = "/{teacherId}")
    public AjaxResult getInfo(@PathVariable("teacherId") Integer teacherId)
    {
        return success(usercenterTeacherInfoService.selectUsercenterTeacherInfoByTeacherId(teacherId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:info:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UsercenterTeacherInfo usercenterTeacherInfo)
    {
        return toAjax(usercenterTeacherInfoService.insertUsercenterTeacherInfo(usercenterTeacherInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:info:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UsercenterTeacherInfo usercenterTeacherInfo)
    {
        return toAjax(usercenterTeacherInfoService.updateUsercenterTeacherInfo(usercenterTeacherInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:info:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teacherIds}")
    public AjaxResult remove(@PathVariable Integer[] teacherIds)
    {
        return toAjax(usercenterTeacherInfoService.deleteUsercenterTeacherInfoByTeacherIds(teacherIds));
    }
}
