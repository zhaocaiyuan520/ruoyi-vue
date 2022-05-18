package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysEdu;
import com.ruoyi.system.service.ISysEduService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
import com.ruoyi.system.domain.SysPersonnel;
import com.ruoyi.system.service.ISysPersonnelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员详情Controller
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
@RestController
@RequestMapping("/system/personnel")
public class SysPersonnelController extends BaseController
{
    @Autowired
    private ISysPersonnelService sysPersonnelService;

    @Autowired
    private ISysEduService sysEduService;
    /**
     * 查询人员详情列表
     */
//    @PreAuthorize("@ss.hasPermi('system:personnel:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPersonnel sysPersonnel)
    {
        startPage();
        List<SysPersonnel> list = sysPersonnelService.selectSysPersonnelList(sysPersonnel);
        return getDataTable(list);
    }

    /**
     * 导出人员详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:personnel:export')")
    @Log(title = "人员详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPersonnel sysPersonnel)
    {
        List<SysPersonnel> list = sysPersonnelService.selectSysPersonnelList(sysPersonnel);
        ExcelUtil<SysPersonnel> util = new ExcelUtil<SysPersonnel>(SysPersonnel.class);
        util.exportExcel(response, list, "人员详情数据");
    }

    /**
     * 获取人员详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:personnel:query')")
    @GetMapping(value = "/{personnelId}")
    public AjaxResult getInfo(@PathVariable("personnelId") Long personnelId)
    {
        return AjaxResult.success(sysPersonnelService.selectSysPersonnelByPersonnelId(personnelId));
    }

    /**
     * 新增人员详情
     */
    @PreAuthorize("@ss.hasPermi('system:personnel:add')")
    @Log(title = "人员详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPersonnel sysPersonnel)
    {
        int personnelId = sysPersonnelService.insertSysPersonnel(sysPersonnel);
        //用户教育经历维护到教育经历表中
        List<SysEdu> eduList = sysPersonnel.getEduList();
        insertEduData((long) personnelId, eduList);

        return toAjax(personnelId);
    }

    /**
     * 修改人员详情
     */
    @PreAuthorize("@ss.hasPermi('system:personnel:edit')")
    @Log(title = "人员详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPersonnel sysPersonnel)
    {
        sysPersonnelService.updateSysPersonnel(sysPersonnel);

        //修改人员信息，修改教育经历 先删除 在插入
        Long personnelId = sysPersonnel.getPersonnelId();
        List<SysEdu> eduList = sysPersonnel.getEduList();
        sysEduService.deleteSysEduByPersonnelId(personnelId);
        insertEduData(personnelId, eduList);


        return toAjax(1);
    }

    private void insertEduData(Long personnelId, List<SysEdu> eduList) {
        if (!CollectionUtils.isEmpty(eduList)) {
            for (SysEdu sysEdu : eduList) {
                sysEdu.setPersonnelId(personnelId);
                sysEduService.insertSysEdu(sysEdu);
            }
        }
    }

    /**
     * 删除人员详情
     */
    @PreAuthorize("@ss.hasPermi('system:personnel:remove')")
    @Log(title = "人员详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{personnelIds}")
    public AjaxResult remove(@PathVariable Long[] personnelIds)
    {
        sysPersonnelService.deleteSysPersonnelByPersonnelIds(personnelIds);
        //删除教育经历
        for (Long personnelId : personnelIds) {
            sysEduService.deleteSysEduByPersonnelId(personnelId);
        }
        return toAjax(1);
    }
}
