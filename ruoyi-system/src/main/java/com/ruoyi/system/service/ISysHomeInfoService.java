package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysHomeInfo;

/**
 * 主页详情Service接口
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
public interface ISysHomeInfoService 
{
    /**
     * 查询主页详情
     * 
     * @param homeId 主页详情主键
     * @return 主页详情
     */
    public SysHomeInfo selectSysHomeInfoByHomeId(Long homeId);

    /**
     * 查询主页详情列表
     * 
     * @param sysHomeInfo 主页详情
     * @return 主页详情集合
     */
    public List<SysHomeInfo> selectSysHomeInfoList(SysHomeInfo sysHomeInfo);

    /**
     * 新增主页详情
     * 
     * @param sysHomeInfo 主页详情
     * @return 结果
     */
    public int insertSysHomeInfo(SysHomeInfo sysHomeInfo);

    /**
     * 修改主页详情
     * 
     * @param sysHomeInfo 主页详情
     * @return 结果
     */
    public int updateSysHomeInfo(SysHomeInfo sysHomeInfo);

    /**
     * 批量删除主页详情
     * 
     * @param homeIds 需要删除的主页详情主键集合
     * @return 结果
     */
    public int deleteSysHomeInfoByHomeIds(Long[] homeIds);

    /**
     * 删除主页详情信息
     * 
     * @param homeId 主页详情主键
     * @return 结果
     */
    public int deleteSysHomeInfoByHomeId(Long homeId);
}
