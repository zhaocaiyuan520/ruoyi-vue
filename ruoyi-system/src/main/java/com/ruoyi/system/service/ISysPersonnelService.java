package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPersonnel;

/**
 * 人员详情Service接口
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
public interface ISysPersonnelService 
{
    /**
     * 查询人员详情
     * 
     * @param personnelId 人员详情主键
     * @return 人员详情
     */
    public SysPersonnel selectSysPersonnelByPersonnelId(Long personnelId);

    /**
     * 查询人员详情列表
     * 
     * @param sysPersonnel 人员详情
     * @return 人员详情集合
     */
    public List<SysPersonnel> selectSysPersonnelList(SysPersonnel sysPersonnel);

    /**
     * 新增人员详情
     * 
     * @param sysPersonnel 人员详情
     * @return 结果
     */
    public int insertSysPersonnel(SysPersonnel sysPersonnel);

    /**
     * 修改人员详情
     * 
     * @param sysPersonnel 人员详情
     * @return 结果
     */
    public int updateSysPersonnel(SysPersonnel sysPersonnel);

    /**
     * 批量删除人员详情
     * 
     * @param personnelIds 需要删除的人员详情主键集合
     * @return 结果
     */
    public int deleteSysPersonnelByPersonnelIds(Long[] personnelIds);

    /**
     * 删除人员详情信息
     * 
     * @param personnelId 人员详情主键
     * @return 结果
     */
    public int deleteSysPersonnelByPersonnelId(Long personnelId);
}
