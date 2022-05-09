package com.ruoyi.web.controller.system;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.uuid.UUID;
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
import com.ruoyi.system.domain.SysLbt;
import com.ruoyi.system.service.ISysLbtService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 轮播图Controller
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/system/lbt")
public class SysLbtController extends BaseController
{
    @Autowired
    private ISysLbtService sysLbtService;

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
        SysLbt sysLbt = new SysLbt();
        String path =  RuoYiConfig.getProfile();
        String realName = file.getOriginalFilename();
        sysLbt.setRealName(realName);
        sysLbt.setFileName(realName);
        //文件类型为 轮播图
        sysLbt.setFileType("0");
        //轮播图 模板文件
        sysLbt.setFileFlag("1");
        try {
            String upload = FileUploadUtils.upload(path, file);
            sysLbt.setFilePath(upload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id = sysLbtService.insertSysLbt(sysLbt);
        return success(String.valueOf(id));

    }


    public static String getRandomName(String realName){
        int index=realName.lastIndexOf(".");
        //获取后缀名
        String fileName=realName.substring(index);
        String uuidFileName= UUID.randomUUID().toString().replace("-","")+fileName;
        return uuidFileName;
    }

}
