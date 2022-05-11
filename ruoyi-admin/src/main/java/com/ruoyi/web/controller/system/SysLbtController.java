package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysLbt;
import com.ruoyi.system.service.ISysFileService;
import com.ruoyi.system.service.ISysLbtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 轮播图Controller
 * 点击    新增 上传图片 返回该条记录的id， 输入外链、排序 点击确定 修改操作
 * @author ruoyi
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/system/lbt")
public class SysLbtController extends BaseController
{
    @Autowired
    private ISysLbtService sysLbtService;
    @Autowired
    private ISysFileService sysFileService;

    /**
     * 查询轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('system:lbt:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysLbt sysLbt)
    {
        startPage();
        List<SysLbt> list = sysLbtService.selectSysLbtList(sysLbt);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('system:lbt:export')")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysLbt sysLbt)
    {
        List<SysLbt> list = sysLbtService.selectSysLbtList(sysLbt);
        ExcelUtil<SysLbt> util = new ExcelUtil<SysLbt>(SysLbt.class);
        util.exportExcel(response, list, "轮播图数据");
    }

    /**
     * 获取轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:lbt:query')")
    @GetMapping(value = "/{lbtId}")
    public AjaxResult getInfo(@PathVariable("lbtId") Long lbtId)
    {
        return AjaxResult.success(sysLbtService.selectSysLbtByLbtId(lbtId));
    }

    /**
     * 新增轮播图
     */
    @PreAuthorize("@ss.hasPermi('system:lbt:add')")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysLbt sysLbt)
    {
        return toAjax(sysLbtService.insertSysLbt(sysLbt));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('system:lbt:edit')")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysLbt sysLbt)
    {
        return toAjax(sysLbtService.updateSysLbt(sysLbt));
    }

    /**
     * 删除轮播图
     */
    @PreAuthorize("@ss.hasPermi('system:lbt:remove')")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lbtIds}")
    public AjaxResult remove(@PathVariable Long[] lbtIds)
    {

        List<SysLbt> sysLbtList = sysLbtService.selectSysLbtListByIds(lbtIds);
        //获取轮播图表中的文件id
        List<Long> collect = sysLbtList.stream().map(sysLbt -> sysLbt.getFileId()).collect(Collectors.toList());
        Long[] fileIds = collect.toArray(new Long[collect.size()]);
        // 删除文件表 和删除文件
        List<SysFileData> sysFileData = sysFileService.selectSysFileListByIds(fileIds);
        for (SysFileData fileData : sysFileData) {
            String filePath = fileData.getFilePath();
            FileUtils.deleteFile(filePath);
        }

        sysFileService.deleteSysFileByLbtIds(fileIds);
        return toAjax(sysLbtService.deleteSysLbtByLbtIds(lbtIds));
    }

    /**
     * 上传
     * @param file
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:lbt:upload')")
    @GetMapping("/upload")
    public AjaxResult upload(MultipartFile file) {
        SysFileData sysFIleData = new SysFileData();
        String path =  RuoYiConfig.getProfile();
        String realName = file.getOriginalFilename();
        sysFIleData.setRealName(realName);


        try {
            String upload = FileUploadUtils.upload(path, file);
            sysFIleData.setFilePath(upload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id = sysFileService.insertSysFile(sysFIleData);
        return success(String.valueOf(id));

    }




}
