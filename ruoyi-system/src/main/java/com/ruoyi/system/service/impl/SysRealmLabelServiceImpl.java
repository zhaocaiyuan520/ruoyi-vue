package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRealmLabelMapper;
import com.ruoyi.system.domain.SysRealmLabel;
import com.ruoyi.system.service.ISysRealmLabelService;

/**
 * 领域标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
@Service
public class SysRealmLabelServiceImpl implements ISysRealmLabelService 
{
    @Autowired
    private SysRealmLabelMapper sysRealmLabelMapper;

    /**
     * 查询领域标签
     * 
     * @param labelId 领域标签主键
     * @return 领域标签
     */
    @Override
    public SysRealmLabel selectSysRealmLabelByLabelId(Long labelId)
    {
        return sysRealmLabelMapper.selectSysRealmLabelByLabelId(labelId);
    }

    /**
     * 查询领域标签列表
     * 
     * @param sysRealmLabel 领域标签
     * @return 领域标签
     */
    @Override
    public List<SysRealmLabel> selectSysRealmLabelList(SysRealmLabel sysRealmLabel)
    {
        return sysRealmLabelMapper.selectSysRealmLabelList(sysRealmLabel);
    }

    /**
     * 新增领域标签
     * 
     * @param sysRealmLabel 领域标签
     * @return 结果
     */
    @Override
    public int insertSysRealmLabel(SysRealmLabel sysRealmLabel)
    {
        sysRealmLabel.setCreateTime(DateUtils.getNowDate());
        return sysRealmLabelMapper.insertSysRealmLabel(sysRealmLabel);
    }

    /**
     * 修改领域标签
     * 
     * @param sysRealmLabel 领域标签
     * @return 结果
     */
    @Override
    public int updateSysRealmLabel(SysRealmLabel sysRealmLabel)
    {
        sysRealmLabel.setUpdateTime(DateUtils.getNowDate());
        return sysRealmLabelMapper.updateSysRealmLabel(sysRealmLabel);
    }

    /**
     * 批量删除领域标签
     * 
     * @param labelIds 需要删除的领域标签主键
     * @return 结果
     */
    @Override
    public int deleteSysRealmLabelByLabelIds(Long[] labelIds)
    {
        return sysRealmLabelMapper.deleteSysRealmLabelByLabelIds(labelIds);
    }

    /**
     * 删除领域标签信息
     * 
     * @param labelId 领域标签主键
     * @return 结果
     */
    @Override
    public int deleteSysRealmLabelByLabelId(Long labelId)
    {
        return sysRealmLabelMapper.deleteSysRealmLabelByLabelId(labelId);
    }
}
