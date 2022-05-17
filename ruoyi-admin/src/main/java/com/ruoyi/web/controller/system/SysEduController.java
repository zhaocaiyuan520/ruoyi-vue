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
import com.ruoyi.system.domain.SysEdu;
import com.ruoyi.system.service.ISysEduService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教育经历Controller
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
@RestController
@RequestMapping("/system/edu")
public class SysEduController extends BaseController
{
    @Autowired
    private ISysEduService sysEduService;

    /**
     * 查询教育经历列表
     */
    @PreAuthorize("@ss.hasPermi('system:edu:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysEdu sysEdu)
    {
        startPage();
        List<SysEdu> list = sysEduService.selectSysEduList(sysEdu);
        return getDataTable(list);
    }

    /**
     * 导出教育经历列表
     */
    @PreAuthorize("@ss.hasPermi('system:edu:export')")
    @Log(title = "教育经历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysEdu sysEdu)
    {
        List<SysEdu> list = sysEduService.selectSysEduList(sysEdu);
        ExcelUtil<SysEdu> util = new ExcelUtil<SysEdu>(SysEdu.class);
        util.exportExcel(response, list, "教育经历数据");
    }

    /**
     * 获取教育经历详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:edu:query')")
    @GetMapping(value = "/{eduId}")
    public AjaxResult getInfo(@PathVariable("eduId") Long eduId)
    {
        return AjaxResult.success(sysEduService.selectSysEduByEduId(eduId));
    }

    /**
     * 新增教育经历
     */
    @PreAuthorize("@ss.hasPermi('system:edu:add')")
    @Log(title = "教育经历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysEdu sysEdu)
    {
        return toAjax(sysEduService.insertSysEdu(sysEdu));
    }

    /**
     * 修改教育经历
     */
    @PreAuthorize("@ss.hasPermi('system:edu:edit')")
    @Log(title = "教育经历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysEdu sysEdu)
    {
        return toAjax(sysEduService.updateSysEdu(sysEdu));
    }

    /**
     * 删除教育经历
     */
    @PreAuthorize("@ss.hasPermi('system:edu:remove')")
    @Log(title = "教育经历", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eduIds}")
    public AjaxResult remove(@PathVariable Long[] eduIds)
    {
        return toAjax(sysEduService.deleteSysEduByEduIds(eduIds));
    }
}
