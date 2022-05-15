package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysFileData;

import java.util.List;

/**
 * @Author: CTX
 * @Date: 2022/05/11/9:18
 * @Description:
 */
public interface ISysFileService {


    /**
     * 上传文件
     *
     * @param sysFileData 上传文件
     * @return 结果
     */
    public int insertSysFile(SysFileData sysFileData);

    List<SysFileData> selectSysFileListByIds(Long[] fileIds);

    public int deleteSysFileByLbtIds(Long[] lbtIds);

    SysFileData selectSysFileByfileId(Long fileId);

    List<SysFileData> selectSysFileList(SysFileData fileData);
}
