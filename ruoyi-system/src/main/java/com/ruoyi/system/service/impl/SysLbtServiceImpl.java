package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysLbtMapper;
import com.ruoyi.system.domain.SysLbt;
import com.ruoyi.system.service.ISysLbtService;

/**
 * 轮播图Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
@Service
public class SysLbtServiceImpl implements ISysLbtService 
{
    @Autowired
    private SysLbtMapper sysLbtMapper;

    /**
     * 查询轮播图
     * 
     * @param lbtId 轮播图主键
     * @return 轮播图
     */
    @Override
    public SysLbt selectSysLbtByLbtId(Long lbtId)
    {
        return sysLbtMapper.selectSysLbtByLbtId(lbtId);
    }

    /**
     * 查询轮播图列表
     * 
     * @param sysLbt 轮播图
     * @return 轮播图
     */
    @Override
    public List<SysLbt> selectSysLbtList(SysLbt sysLbt)
    {
        return sysLbtMapper.selectSysLbtList(sysLbt);
    }

    /**
     * 新增轮播图
     * 
     * @param sysLbt 轮播图
     * @return 结果
     */
    @Override
    public int insertSysLbt(SysLbt sysLbt)
    {
        sysLbt.setCreateTime(DateUtils.getNowDate());
        sysLbtMapper.insertSysLbt(sysLbt);
        Long lbtId = sysLbt.getLbtId();
        return lbtId.intValue();
    }

    /**
     * 修改轮播图
     * 
     * @param sysLbt 轮播图
     * @return 结果
     */
    @Override
    public int updateSysLbt(SysLbt sysLbt)
    {
        sysLbt.setUpdateTime(DateUtils.getNowDate());
        return sysLbtMapper.updateSysLbt(sysLbt);
    }

    /**
     * 批量删除轮播图
     * 
     * @param lbtIds 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deleteSysLbtByLbtIds(Long[] lbtIds)
    {
        return sysLbtMapper.deleteSysLbtByLbtIds(lbtIds);
    }

    /**
     * 删除轮播图信息
     * 
     * @param lbtId 轮播图主键
     * @return 结果
     */
    @Override
    public int deleteSysLbtByLbtId(Long lbtId)
    {
        return sysLbtMapper.deleteSysLbtByLbtId(lbtId);
    }
}
