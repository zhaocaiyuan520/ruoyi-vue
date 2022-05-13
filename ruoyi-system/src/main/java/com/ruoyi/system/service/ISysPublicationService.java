package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPublication;

/**
 * 出版物模块详情Service接口
 * 
 * @author ruoyi
 * @date 2022-05-13
 */
public interface ISysPublicationService 
{
    /**
     * 查询出版物模块详情
     * 
     * @param id 出版物模块详情主键
     * @return 出版物模块详情
     */
    public SysPublication selectSysPublicationById(Long id);

    /**
     * 查询出版物模块详情列表
     * 
     * @param sysPublication 出版物模块详情
     * @return 出版物模块详情集合
     */
    public List<SysPublication> selectSysPublicationList(SysPublication sysPublication);

    /**
     * 新增出版物模块详情
     * 
     * @param sysPublication 出版物模块详情
     * @return 结果
     */
    public int insertSysPublication(SysPublication sysPublication);

    /**
     * 修改出版物模块详情
     * 
     * @param sysPublication 出版物模块详情
     * @return 结果
     */
    public int updateSysPublication(SysPublication sysPublication);

    /**
     * 批量删除出版物模块详情
     * 
     * @param ids 需要删除的出版物模块详情主键集合
     * @return 结果
     */
    public int deleteSysPublicationByIds(Long[] ids);

    /**
     * 删除出版物模块详情信息
     * 
     * @param id 出版物模块详情主键
     * @return 结果
     */
    public int deleteSysPublicationById(Long id);
}
