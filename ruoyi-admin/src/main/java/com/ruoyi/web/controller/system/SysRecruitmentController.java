package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysRecruitment;
import com.ruoyi.system.service.ISysRecruitmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招聘Controller
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
@RestController
@RequestMapping("/system/recruitment")
public class SysRecruitmentController extends BaseController
{
    @Autowired
    private ISysRecruitmentService sysRecruitmentService;

    /**
     * 查询招聘列表
     */
    @PreAuthorize("@ss.hasPermi('system:recruitment:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRecruitment sysRecruitment)
    {
        startPage();
        List<SysRecruitment> list = sysRecruitmentService.selectSysRecruitmentList(sysRecruitment);
        return getDataTable(list);
    }

    /**
     * 导出招聘列表
     */
    @PreAuthorize("@ss.hasPermi('system:recruitment:export')")
    @Log(title = "招聘", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRecruitment sysRecruitment)
    {
        List<SysRecruitment> list = sysRecruitmentService.selectSysRecruitmentList(sysRecruitment);
        ExcelUtil<SysRecruitment> util = new ExcelUtil<SysRecruitment>(SysRecruitment.class);
        util.exportExcel(response, list, "招聘数据");
    }

    /**
     * 获取招聘详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:recruitment:query')")
    @GetMapping(value = "/{recruitId}")
    public AjaxResult getInfo(@PathVariable("recruitId") Long recruitId)
    {
        return AjaxResult.success(sysRecruitmentService.selectSysRecruitmentByRecruitId(recruitId));
    }

    /**
     * 新增招聘
     */
    @PreAuthorize("@ss.hasPermi('system:recruitment:add')")
    @Log(title = "招聘", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRecruitment sysRecruitment)
    {
        return toAjax(sysRecruitmentService.insertSysRecruitment(sysRecruitment));
    }

    /**
     * 修改招聘
     */
    @PreAuthorize("@ss.hasPermi('system:recruitment:edit')")
    @Log(title = "招聘", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRecruitment sysRecruitment)
    {
        return toAjax(sysRecruitmentService.updateSysRecruitment(sysRecruitment));
    }

    /**
     * 删除招聘
     */
    @PreAuthorize("@ss.hasPermi('system:recruitment:remove')")
    @Log(title = "招聘", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recruitIds}")
    public AjaxResult remove(@PathVariable Long[] recruitIds)
    {
        return toAjax(sysRecruitmentService.deleteSysRecruitmentByRecruitIds(recruitIds));
    }
}
