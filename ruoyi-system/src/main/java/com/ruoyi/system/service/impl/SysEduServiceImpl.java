package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysEduMapper;
import com.ruoyi.system.domain.SysEdu;
import com.ruoyi.system.service.ISysEduService;

/**
 * 教育经历Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
@Service
public class SysEduServiceImpl implements ISysEduService 
{
    @Autowired
    private SysEduMapper sysEduMapper;

    /**
     * 查询教育经历
     * 
     * @param eduId 教育经历主键
     * @return 教育经历
     */
    @Override
    public SysEdu selectSysEduByEduId(Long eduId)
    {
        return sysEduMapper.selectSysEduByEduId(eduId);
    }

    /**
     * 查询教育经历列表
     * 
     * @param sysEdu 教育经历
     * @return 教育经历
     */
    @Override
    public List<SysEdu> selectSysEduList(SysEdu sysEdu)
    {
        return sysEduMapper.selectSysEduList(sysEdu);
    }

    /**
     * 新增教育经历
     * 
     * @param sysEdu 教育经历
     * @return 结果
     */
    @Override
    public int insertSysEdu(SysEdu sysEdu)
    {
        sysEdu.setCreateTime(DateUtils.getNowDate());
        return sysEduMapper.insertSysEdu(sysEdu);
    }

    /**
     * 修改教育经历
     * 
     * @param sysEdu 教育经历
     * @return 结果
     */
    @Override
    public int updateSysEdu(SysEdu sysEdu)
    {
        sysEdu.setUpdateTime(DateUtils.getNowDate());
        return sysEduMapper.updateSysEdu(sysEdu);
    }

    /**
     * 批量删除教育经历
     * 
     * @param eduIds 需要删除的教育经历主键
     * @return 结果
     */
    @Override
    public int deleteSysEduByEduIds(Long[] eduIds)
    {
        return sysEduMapper.deleteSysEduByEduIds(eduIds);
    }

    /**
     * 删除教育经历信息
     * 
     * @param eduId 教育经历主键
     * @return 结果
     */
    @Override
    public int deleteSysEduByEduId(Long eduId)
    {
        return sysEduMapper.deleteSysEduByEduId(eduId);
    }

    /**
     * 删除教育经历信息
     *
     * @param eduId 教育经历主键
     * @return 结果
     */
    @Override
    public int deleteSysEduByPersonnelId(Long personnelId)
    {
        return sysEduMapper.deleteSysEduByPersonnelId(personnelId);
    }
}
