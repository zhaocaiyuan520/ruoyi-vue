package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.mapper.SysFileMapper;
import com.ruoyi.system.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: CTX
 * @Date: 2022/05/11/9:19
 * @Description:
 */
@Service
public class SysFileServiceImpl implements ISysFileService {
    @Autowired
    private SysFileMapper sysFileMapper;
    @Override
    public int insertSysFile(SysFileData sysFileData) {
        sysFileData.setCreateTime(DateUtils.getNowDate());
        sysFileMapper.insertSysFile(sysFileData);
        Long lbtId = sysFileData.getFileId();
        return lbtId.intValue();
    }

    @Override
    public List<SysFileData> selectSysFileListByIds(Long[] fileIds) {
        return sysFileMapper.selectSysFileListByIds(fileIds);
    }

    @Override
    public int deleteSysFileByLbtIds(Long[] fileIds) {
        return sysFileMapper.deleteSysFileByfileIds(fileIds);
    }

    @Override
    public SysFileData selectSysFileByfileId(Long fileId) {
        return sysFileMapper.selectSysFileByfileId(fileId);
    }
}
