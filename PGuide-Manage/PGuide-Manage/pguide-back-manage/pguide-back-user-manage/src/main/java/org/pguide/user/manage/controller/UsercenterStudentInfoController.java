package org.pguide.user.manage.controller;


import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.pguide.user.manage.entity.UsercenterStudentInfo;
import org.pguide.user.manage.service.IUsercenterStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/project/info/student")
@DataSource(value= DataSourceType.USER)
public class UsercenterStudentInfoController extends BaseController
{
    @Autowired
    private IUsercenterStudentInfoService usercenterStudentInfoService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(UsercenterStudentInfo usercenterStudentInfo)
    {
        startPage();
        List<UsercenterStudentInfo> list = usercenterStudentInfoService.selectUsercenterStudentInfoList(usercenterStudentInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('project:info:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UsercenterStudentInfo usercenterStudentInfo)
    {
        List<UsercenterStudentInfo> list = usercenterStudentInfoService.selectUsercenterStudentInfoList(usercenterStudentInfo);
        ExcelUtil<UsercenterStudentInfo> util = new ExcelUtil<UsercenterStudentInfo>(UsercenterStudentInfo.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:info:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(usercenterStudentInfoService.selectUsercenterStudentInfoByStudentId(studentId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:info:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UsercenterStudentInfo usercenterStudentInfo)
    {
        return toAjax(usercenterStudentInfoService.insertUsercenterStudentInfo(usercenterStudentInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:info:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UsercenterStudentInfo usercenterStudentInfo)
    {
        return toAjax(usercenterStudentInfoService.updateUsercenterStudentInfo(usercenterStudentInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('project:info:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(usercenterStudentInfoService.deleteUsercenterStudentInfoByStudentIds(studentIds));
    }
}
