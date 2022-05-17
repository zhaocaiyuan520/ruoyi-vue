package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPersonnelMapper;
import com.ruoyi.system.domain.SysPersonnel;
import com.ruoyi.system.service.ISysPersonnelService;

/**
 * 人员详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
@Service
public class SysPersonnelServiceImpl implements ISysPersonnelService 
{
    @Autowired
    private SysPersonnelMapper sysPersonnelMapper;

    /**
     * 查询人员详情
     * 
     * @param personnelId 人员详情主键
     * @return 人员详情
     */
    @Override
    public SysPersonnel selectSysPersonnelByPersonnelId(Long personnelId)
    {
        return sysPersonnelMapper.selectSysPersonnelByPersonnelId(personnelId);
    }

    /**
     * 查询人员详情列表
     * 
     * @param sysPersonnel 人员详情
     * @return 人员详情
     */
    @Override
    public List<SysPersonnel> selectSysPersonnelList(SysPersonnel sysPersonnel)
    {
        return sysPersonnelMapper.selectSysPersonnelList(sysPersonnel);
    }

    /**
     * 新增人员详情
     * 
     * @param sysPersonnel 人员详情
     * @return 结果
     */
    @Override
    public int insertSysPersonnel(SysPersonnel sysPersonnel)
    {
        sysPersonnel.setCreateTime(DateUtils.getNowDate());
        return sysPersonnelMapper.insertSysPersonnel(sysPersonnel);
    }

    /**
     * 修改人员详情
     * 
     * @param sysPersonnel 人员详情
     * @return 结果
     */
    @Override
    public int updateSysPersonnel(SysPersonnel sysPersonnel)
    {
        sysPersonnel.setUpdateTime(DateUtils.getNowDate());
        return sysPersonnelMapper.updateSysPersonnel(sysPersonnel);
    }

    /**
     * 批量删除人员详情
     * 
     * @param personnelIds 需要删除的人员详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonnelByPersonnelIds(Long[] personnelIds)
    {
        return sysPersonnelMapper.deleteSysPersonnelByPersonnelIds(personnelIds);
    }

    /**
     * 删除人员详情信息
     * 
     * @param personnelId 人员详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonnelByPersonnelId(Long personnelId)
    {
        return sysPersonnelMapper.deleteSysPersonnelByPersonnelId(personnelId);
    }
}
