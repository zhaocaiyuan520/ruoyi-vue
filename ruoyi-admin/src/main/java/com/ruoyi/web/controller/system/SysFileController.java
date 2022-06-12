package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysLbt;
import com.ruoyi.system.domain.SysPublication;
import com.ruoyi.system.service.ISysFileService;
import com.ruoyi.system.service.ISysLbtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 轮播图Controller
 * 点击    新增 上传图片 返回该条记录的id， 输入外链、排序 点击确定 修改操作
 *
 * @author ruoyi
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/system/file")
public class SysFileController extends BaseController {

    @Autowired
    private ISysFileService sysFileService;

    @GetMapping("/list")
    public TableDataInfo list(SysFileData fileData)
    {
        startPage();
        List<SysFileData> list = sysFileService.selectSysFileList(fileData);
        return getDataTable(list);
    }

    /**
     * 上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file, String fileType) throws Exception {
        SysFileData sysFIleData = new SysFileData();
        String path = RuoYiConfig.getProfile();
        String realName = file.getOriginalFilename();
        sysFIleData.setRealName(realName);
        //0:首页轮播图，1：PDF文章 ,2: 常用文件
        sysFIleData.setFileType(fileType);
        //根据类型区分不同文件夹
        if (fileType.equals(Constants.IS_IMG_FILE)) {
            path = path + File.separatorChar + Constants.IMG_PATH;
        } else if (fileType.equals(Constants.IS_PDF_FILE)) {
            path = path + File.separatorChar + Constants.PDF_PATH;
        }else if (fileType.equals(Constants.IS_CY_FILE)){
            path = path + File.separatorChar + Constants.CY_PATH;
        }
        logger.info("上传文件路径为~~~~~~~~~~~~~~~~~~~~,{}", path);
        String upload = FileUploadUtils.upload(path, file);
        sysFIleData.setFilePath(upload);
        int id = sysFileService.insertSysFile(sysFIleData);
        return success(String.valueOf(id));

    }


    /**
     * 通用下载请求
     *
     * @param fileId 文件id
     */
    @GetMapping("/download")
    public AjaxResult fileDownload(Long fileId, HttpServletResponse response) {
        try {
            SysFileData sysFileData = sysFileService.selectSysFileByfileId(fileId);
            if (sysFileData != null) {
                String filePath = sysFileData.getFilePath();
                String realName = sysFileData.getRealName();
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                FileUtils.setAttachmentResponseHeader(response, realName);
                FileUtils.writeBytes(filePath, response.getOutputStream());
                return AjaxResult.success(1);
            } else {
                return error("未找到相关文件");
            }

        } catch (Exception e) {
            logger.error("下载文件失败", e);
            return error("下载文件失败");
        }
    }

    /**
     * 删除文件
     */
//    @Log(title = "文件删除", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {

        // 删除文件表 和删除文件
        List<SysFileData> sysFileData = sysFileService.selectSysFileListByIds(fileIds);
        for (SysFileData fileData : sysFileData) {
            String filePath = fileData.getFilePath();
            if(StringUtils.isNotEmpty(filePath)){
                FileUtils.deleteFile(filePath);
            }
        }
        sysFileService.deleteSysFileByLbtIds(fileIds);
        return toAjax(1);
    }
}
