package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysLinkMapper;
import com.ruoyi.system.domain.SysLink;
import com.ruoyi.system.service.ISysLinkService;

/**
 * 链接Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
@Service
public class SysLinkServiceImpl implements ISysLinkService 
{
    @Autowired
    private SysLinkMapper sysLinkMapper;

    /**
     * 查询链接
     * 
     * @param linkId 链接主键
     * @return 链接
     */
    @Override
    public SysLink selectSysLinkByLinkId(Long linkId)
    {
        return sysLinkMapper.selectSysLinkByLinkId(linkId);
    }

    /**
     * 查询链接列表
     * 
     * @param sysLink 链接
     * @return 链接
     */
    @Override
    public List<SysLink> selectSysLinkList(SysLink sysLink)
    {
        return sysLinkMapper.selectSysLinkList(sysLink);
    }

    /**
     * 新增链接
     * 
     * @param sysLink 链接
     * @return 结果
     */
    @Override
    public int insertSysLink(SysLink sysLink)
    {
        sysLink.setCreateTime(DateUtils.getNowDate());
        return sysLinkMapper.insertSysLink(sysLink);
    }

    /**
     * 修改链接
     * 
     * @param sysLink 链接
     * @return 结果
     */
    @Override
    public int updateSysLink(SysLink sysLink)
    {
        sysLink.setUpdateTime(DateUtils.getNowDate());
        return sysLinkMapper.updateSysLink(sysLink);
    }

    /**
     * 批量删除链接
     * 
     * @param linkIds 需要删除的链接主键
     * @return 结果
     */
    @Override
    public int deleteSysLinkByLinkIds(Long[] linkIds)
    {
        return sysLinkMapper.deleteSysLinkByLinkIds(linkIds);
    }

    /**
     * 删除链接信息
     * 
     * @param linkId 链接主键
     * @return 结果
     */
    @Override
    public int deleteSysLinkByLinkId(Long linkId)
    {
        return sysLinkMapper.deleteSysLinkByLinkId(linkId);
    }
}
