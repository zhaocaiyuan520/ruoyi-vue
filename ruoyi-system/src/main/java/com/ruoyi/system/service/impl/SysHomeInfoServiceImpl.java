package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysHomeInfoMapper;
import com.ruoyi.system.domain.SysHomeInfo;
import com.ruoyi.system.service.ISysHomeInfoService;

/**
 * 主页详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
@Service
public class SysHomeInfoServiceImpl implements ISysHomeInfoService 
{
    @Autowired
    private SysHomeInfoMapper sysHomeInfoMapper;

    /**
     * 查询主页详情
     * 
     * @param homeId 主页详情主键
     * @return 主页详情
     */
    @Override
    public SysHomeInfo selectSysHomeInfoByHomeId(Long homeId)
    {
        return sysHomeInfoMapper.selectSysHomeInfoByHomeId(homeId);
    }

    /**
     * 查询主页详情列表
     * 
     * @param sysHomeInfo 主页详情
     * @return 主页详情
     */
    @Override
    public List<SysHomeInfo> selectSysHomeInfoList(SysHomeInfo sysHomeInfo)
    {
        return sysHomeInfoMapper.selectSysHomeInfoList(sysHomeInfo);
    }

    /**
     * 新增主页详情
     * 
     * @param sysHomeInfo 主页详情
     * @return 结果
     */
    @Override
    public int insertSysHomeInfo(SysHomeInfo sysHomeInfo)
    {
        sysHomeInfo.setCreateTime(DateUtils.getNowDate());
        return sysHomeInfoMapper.insertSysHomeInfo(sysHomeInfo);
    }

    /**
     * 修改主页详情
     * 
     * @param sysHomeInfo 主页详情
     * @return 结果
     */
    @Override
    public int updateSysHomeInfo(SysHomeInfo sysHomeInfo)
    {
        sysHomeInfo.setUpdateTime(DateUtils.getNowDate());
        return sysHomeInfoMapper.updateSysHomeInfo(sysHomeInfo);
    }

    /**
     * 批量删除主页详情
     * 
     * @param homeIds 需要删除的主页详情主键
     * @return 结果
     */
    @Override
    public int deleteSysHomeInfoByHomeIds(Long[] homeIds)
    {
        return sysHomeInfoMapper.deleteSysHomeInfoByHomeIds(homeIds);
    }

    /**
     * 删除主页详情信息
     * 
     * @param homeId 主页详情主键
     * @return 结果
     */
    @Override
    public int deleteSysHomeInfoByHomeId(Long homeId)
    {
        return sysHomeInfoMapper.deleteSysHomeInfoByHomeId(homeId);
    }
}
