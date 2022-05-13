package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPublicationMapper;
import com.ruoyi.system.domain.SysPublication;
import com.ruoyi.system.service.ISysPublicationService;

/**
 * 出版物模块详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-13
 */
@Service
public class SysPublicationServiceImpl implements ISysPublicationService 
{
    @Autowired
    private SysPublicationMapper sysPublicationMapper;

    /**
     * 查询出版物模块详情
     * 
     * @param id 出版物模块详情主键
     * @return 出版物模块详情
     */
    @Override
    public SysPublication selectSysPublicationById(Long id)
    {
        return sysPublicationMapper.selectSysPublicationById(id);
    }

    /**
     * 查询出版物模块详情列表
     * 
     * @param sysPublication 出版物模块详情
     * @return 出版物模块详情
     */
    @Override
    public List<SysPublication> selectSysPublicationList(SysPublication sysPublication)
    {
        return sysPublicationMapper.selectSysPublicationList(sysPublication);
    }

    /**
     * 新增出版物模块详情
     * 
     * @param sysPublication 出版物模块详情
     * @return 结果
     */
    @Override
    public int insertSysPublication(SysPublication sysPublication)
    {
        sysPublication.setCreateTime(DateUtils.getNowDate());
        return sysPublicationMapper.insertSysPublication(sysPublication);
    }

    /**
     * 修改出版物模块详情
     * 
     * @param sysPublication 出版物模块详情
     * @return 结果
     */
    @Override
    public int updateSysPublication(SysPublication sysPublication)
    {
        sysPublication.setUpdateTime(DateUtils.getNowDate());
        return sysPublicationMapper.updateSysPublication(sysPublication);
    }

    /**
     * 批量删除出版物模块详情
     * 
     * @param ids 需要删除的出版物模块详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPublicationByIds(Long[] ids)
    {
        return sysPublicationMapper.deleteSysPublicationByIds(ids);
    }

    /**
     * 删除出版物模块详情信息
     * 
     * @param id 出版物模块详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPublicationById(Long id)
    {
        return sysPublicationMapper.deleteSysPublicationById(id);
    }
}
