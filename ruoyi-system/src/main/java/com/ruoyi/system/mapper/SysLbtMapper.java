package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysLbt;

/**
 * 轮播图Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
public interface SysLbtMapper 
{
    /**
     * 查询轮播图
     * 
     * @param lbtId 轮播图主键
     * @return 轮播图
     */
    public SysLbt selectSysLbtByLbtId(Long lbtId);

    /**
     * 查询轮播图列表
     * 
     * @param sysLbt 轮播图
     * @return 轮播图集合
     */
    public List<SysLbt> selectSysLbtList(SysLbt sysLbt);

    /**
     * 新增轮播图
     * 
     * @param sysLbt 轮播图
     * @return 结果
     */
    public int insertSysLbt(SysLbt sysLbt);

    /**
     * 修改轮播图
     * 
     * @param sysLbt 轮播图
     * @return 结果
     */
    public int updateSysLbt(SysLbt sysLbt);

    /**
     * 删除轮播图
     * 
     * @param lbtId 轮播图主键
     * @return 结果
     */
    public int deleteSysLbtByLbtId(Long lbtId);

    /**
     * 批量删除轮播图
     * 
     * @param lbtIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysLbtByLbtIds(Long[] lbtIds);
}
