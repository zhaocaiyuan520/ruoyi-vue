package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysHomeArticle;
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
import com.ruoyi.system.domain.SysPublication;
import com.ruoyi.system.service.ISysPublicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出版物模块详情Controller
 *
 * @author ruoyi
 * @date 2022-05-13
 */
@RestController
@RequestMapping("/system/publication")
public class SysPublicationController extends BaseController {
    @Autowired
    private ISysPublicationService sysPublicationService;
    @Autowired
    private ISysFileService sysFileService;

    /**
     * 查询出版物模块详情列表
     */
//    @PreAuthorize("@ss.hasPermi('system:publication:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPublication sysPublication) {
        startPage();
        List<SysPublication> list = sysPublicationService.selectSysPublicationList(sysPublication);
        Map<String, List<SysPublication>> yearMap = list.stream().collect(Collectors.groupingBy(SysPublication::getYear));
        return getDataTable(list);
    }

    /**
     * 查询出版物模块详情列表
     */
//    @PreAuthorize("@ss.hasPermi('system:publication:list')")
    @GetMapping("/map")
    public Map<String, List<SysPublication>> map(SysPublication sysPublication) {
        startPage();
        List<SysPublication> list = sysPublicationService.selectSysPublicationList(sysPublication);
        Map<String, List<SysPublication>> yearMap = list.stream().collect(Collectors.groupingBy(SysPublication::getYear, LinkedHashMap::new, Collectors.toList()));

        return yearMap;
    }

    /**
     * 导出出版物模块详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:publication:export')")
    @Log(title = "出版物模块详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPublication sysPublication) {
        List<SysPublication> list = sysPublicationService.selectSysPublicationList(sysPublication);
        ExcelUtil<SysPublication> util = new ExcelUtil<SysPublication>(SysPublication.class);
        util.exportExcel(response, list, "出版物模块详情数据");
    }

    /**
     * 获取出版物模块详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:publication:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysPublicationService.selectSysPublicationById(id));
    }

    /**
     * 新增出版物模块详情
     */
    @PreAuthorize("@ss.hasPermi('system:publication:add')")
    @Log(title = "出版物模块详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPublication sysPublication) {
        return toAjax(sysPublicationService.insertSysPublication(sysPublication));
    }

    /**
     * 修改出版物模块详情
     */
    @PreAuthorize("@ss.hasPermi('system:publication:edit')")
    @Log(title = "出版物模块详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPublication sysPublication) {
        return toAjax(sysPublicationService.updateSysPublication(sysPublication));
    }

    /**
     * 删除出版物模块详情
     */
    @PreAuthorize("@ss.hasPermi('system:publication:remove')")
    @Log(title = "出版物模块详情", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {

        List<Long> collect = new ArrayList<>();
        for (Long id : ids) {
            SysPublication sysPublication = sysPublicationService.selectSysPublicationById(id);
            if(sysPublication.getImgId()!=null){
                collect.add(sysPublication.getImgId());
            }
            if(sysPublication.getPdfId()!=null){
                collect.add(sysPublication.getPdfId());
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


        return toAjax(sysPublicationService.deleteSysPublicationByIds(ids));
    }
}
