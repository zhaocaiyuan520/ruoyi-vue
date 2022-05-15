package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysLbt;

import java.util.List;

/**
 * @Author: CTX
 * @Date: 2022/05/11/9:21
 * @Description:
 */
public interface SysFileMapper {
    /**
     * 插入数据
     * @param sysFileData
     * @return
     */
    public int insertSysFile(SysFileData sysFileData);

    int updateSysFile(SysFileData sysFileData);


    /**
     *
     * @param lbtIds
     * @return
     */
    public List<SysFileData> selectSysFileListByIds(Long[] lbtIds);

    int deleteSysFileByfileIds(Long[] fileIds);

    SysFileData selectSysFileByfileId(Long fileId);

    List<SysFileData> selectSysFileList(SysFileData fileData);
}
