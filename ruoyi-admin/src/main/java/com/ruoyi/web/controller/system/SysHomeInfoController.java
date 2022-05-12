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
import com.ruoyi.system.domain.SysHomeInfo;
import com.ruoyi.system.service.ISysHomeInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 主页详情Controller
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/system/info")
public class SysHomeInfoController extends BaseController
{
    @Autowired
    private ISysHomeInfoService sysHomeInfoService;

    /**
     * 查询主页详情列表
     */
//    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysHomeInfo sysHomeInfo)
    {
        startPage();
        List<SysHomeInfo> list = sysHomeInfoService.selectSysHomeInfoList(sysHomeInfo);
        return getDataTable(list);
    }

    /**
     * 导出主页详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "主页详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysHomeInfo sysHomeInfo)
    {
        List<SysHomeInfo> list = sysHomeInfoService.selectSysHomeInfoList(sysHomeInfo);
        ExcelUtil<SysHomeInfo> util = new ExcelUtil<SysHomeInfo>(SysHomeInfo.class);
        util.exportExcel(response, list, "主页详情数据");
    }

    /**
     * 获取主页详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{homeId}")
    public AjaxResult getInfo(@PathVariable("homeId") Long homeId)
    {
        return AjaxResult.success(sysHomeInfoService.selectSysHomeInfoByHomeId(homeId));
    }

    /**
     * 新增主页详情
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "主页详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysHomeInfo sysHomeInfo)
    {
        return toAjax(sysHomeInfoService.insertSysHomeInfo(sysHomeInfo));
    }

    /**
     * 修改主页详情
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "主页详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysHomeInfo sysHomeInfo)
    {
        return toAjax(sysHomeInfoService.updateSysHomeInfo(sysHomeInfo));
    }

    /**
     * 删除主页详情
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "主页详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{homeIds}")
    public AjaxResult remove(@PathVariable Long[] homeIds)
    {
        return toAjax(sysHomeInfoService.deleteSysHomeInfoByHomeIds(homeIds));
    }
}
