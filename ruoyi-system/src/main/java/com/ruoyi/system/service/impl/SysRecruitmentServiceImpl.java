package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRecruitmentMapper;
import com.ruoyi.system.domain.SysRecruitment;
import com.ruoyi.system.service.ISysRecruitmentService;

/**
 * 招聘Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
@Service
public class SysRecruitmentServiceImpl implements ISysRecruitmentService 
{
    @Autowired
    private SysRecruitmentMapper sysRecruitmentMapper;

    /**
     * 查询招聘
     * 
     * @param recruitId 招聘主键
     * @return 招聘
     */
    @Override
    public SysRecruitment selectSysRecruitmentByRecruitId(Long recruitId)
    {
        return sysRecruitmentMapper.selectSysRecruitmentByRecruitId(recruitId);
    }

    /**
     * 查询招聘列表
     * 
     * @param sysRecruitment 招聘
     * @return 招聘
     */
    @Override
    public List<SysRecruitment> selectSysRecruitmentList(SysRecruitment sysRecruitment)
    {
        return sysRecruitmentMapper.selectSysRecruitmentList(sysRecruitment);
    }

    /**
     * 新增招聘
     * 
     * @param sysRecruitment 招聘
     * @return 结果
     */
    @Override
    public int insertSysRecruitment(SysRecruitment sysRecruitment)
    {
        sysRecruitment.setCreateTime(DateUtils.getNowDate());
        return sysRecruitmentMapper.insertSysRecruitment(sysRecruitment);
    }

    /**
     * 修改招聘
     * 
     * @param sysRecruitment 招聘
     * @return 结果
     */
    @Override
    public int updateSysRecruitment(SysRecruitment sysRecruitment)
    {
        sysRecruitment.setUpdateTime(DateUtils.getNowDate());
        return sysRecruitmentMapper.updateSysRecruitment(sysRecruitment);
    }

    /**
     * 批量删除招聘
     * 
     * @param recruitIds 需要删除的招聘主键
     * @return 结果
     */
    @Override
    public int deleteSysRecruitmentByRecruitIds(Long[] recruitIds)
    {
        return sysRecruitmentMapper.deleteSysRecruitmentByRecruitIds(recruitIds);
    }

    /**
     * 删除招聘信息
     * 
     * @param recruitId 招聘主键
     * @return 结果
     */
    @Override
    public int deleteSysRecruitmentByRecruitId(Long recruitId)
    {
        return sysRecruitmentMapper.deleteSysRecruitmentByRecruitId(recruitId);
    }
}
