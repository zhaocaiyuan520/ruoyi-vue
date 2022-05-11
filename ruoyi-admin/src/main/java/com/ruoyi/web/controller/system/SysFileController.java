package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysLbt;
import com.ruoyi.system.service.ISysFileService;
import com.ruoyi.system.service.ISysLbtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

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


    /**
     * 上传
     *
     * @param file
     * @return
     */
    @GetMapping("/upload")
    public AjaxResult upload(MultipartFile file, String fileType) throws Exception{
        SysFileData sysFIleData = new SysFileData();
        String path = RuoYiConfig.getProfile();
        String realName = file.getOriginalFilename();
        sysFIleData.setRealName(realName);
        //0:首页轮播图，1：PDF文章
        sysFIleData.setFileType(fileType);
        //根据类型区分不同文件夹
        if (fileType.equals(Constants.IS_IMG_FILE)) {
            path = path + File.separatorChar + Constants.IMG_PATH;
        } else if (fileType.equals(Constants.IS_PDF_FILE)) {
            path = path + File.separatorChar + Constants.PDF_PATH;
        }
        logger.info("上传文件路径为~~~~~~~~~~~~~~~~~~~~,{}", path);
        String upload = FileUploadUtils.upload(path, file);
        sysFIleData.setFilePath(upload);
        int id = sysFileService.insertSysFile(sysFIleData);
        return success(String.valueOf(id));

    }


}
