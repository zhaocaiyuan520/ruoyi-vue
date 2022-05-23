package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysLink;

/**
 * 链接Service接口
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
public interface ISysLinkService 
{
    /**
     * 查询链接
     * 
     * @param linkId 链接主键
     * @return 链接
     */
    public SysLink selectSysLinkByLinkId(Long linkId);

    /**
     * 查询链接列表
     * 
     * @param sysLink 链接
     * @return 链接集合
     */
    public List<SysLink> selectSysLinkList(SysLink sysLink);

    /**
     * 新增链接
     * 
     * @param sysLink 链接
     * @return 结果
     */
    public int insertSysLink(SysLink sysLink);

    /**
     * 修改链接
     * 
     * @param sysLink 链接
     * @return 结果
     */
    public int updateSysLink(SysLink sysLink);

    /**
     * 批量删除链接
     * 
     * @param linkIds 需要删除的链接主键集合
     * @return 结果
     */
    public int deleteSysLinkByLinkIds(Long[] linkIds);

    /**
     * 删除链接信息
     * 
     * @param linkId 链接主键
     * @return 结果
     */
    public int deleteSysLinkByLinkId(Long linkId);
}
