package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysPublication;
import com.ruoyi.system.service.ISysFileService;
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
import com.ruoyi.system.domain.SysCourse;
import com.ruoyi.system.service.ISysCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课件Controller
 * 
 * @author ruoyi
 * @date 2022-05-16
 */
@RestController
@RequestMapping("/system/course")
public class SysCourseController extends BaseController
{
    @Autowired
    private ISysCourseService sysCourseService;
    @Autowired
    private ISysFileService sysFileService;
    /**
     * 查询课件列表
     */
//    @PreAuthorize("@ss.hasPermi('system:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCourse sysCourse)
    {
        startPage();
        List<SysCourse> list = sysCourseService.selectSysCourseList(sysCourse);
        return getDataTable(list);
    }

    /**
     * 导出课件列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:export')")
    @Log(title = "课件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCourse sysCourse)
    {
        List<SysCourse> list = sysCourseService.selectSysCourseList(sysCourse);
        ExcelUtil<SysCourse> util = new ExcelUtil<SysCourse>(SysCourse.class);
        util.exportExcel(response, list, "课件数据");
    }

    /**
     * 获取课件详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return AjaxResult.success(sysCourseService.selectSysCourseByCourseId(courseId));
    }

    /**
     * 新增课件
     */
    @PreAuthorize("@ss.hasPermi('system:course:add')")
    @Log(title = "课件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCourse sysCourse)
    {
        return toAjax(sysCourseService.insertSysCourse(sysCourse));
    }

    /**
     * 修改课件
     */
    @PreAuthorize("@ss.hasPermi('system:course:edit')")
    @Log(title = "课件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCourse sysCourse)
    {
        return toAjax(sysCourseService.updateSysCourse(sysCourse));
    }

    /**
     * 删除课件
     */
    @PreAuthorize("@ss.hasPermi('system:course:remove')")
    @Log(title = "课件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {

        List<Long> collect = new ArrayList<>();
        for (Long id : courseIds) {
            SysCourse sysCourse = sysCourseService.selectSysCourseByCourseId(id);
            if(sysCourse.getFileId()!=null){
                collect.add(sysCourse.getFileId());
            }
        }
        //id 不为空则去删除
        if (!CollectionUtils.isEmpty(collect)) {
            Long[] fileIds = collect.toArray(new Long[collect.size()]);
            // 删除文件表 和删除文件
            List<SysFileData> sysFileData = sysFileService.selectSysFileListByIds(fileIds);
            for (SysFileData fileData : sysFileData) {
                String filePath = fileData.getFilePath();
                FileUtils.deleteFile(filePath);
            }
            sysFileService.deleteSysFileByLbtIds(fileIds);

        }

        return toAjax(sysCourseService.deleteSysCourseByCourseIds(courseIds));
    }
}
