package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysEdu;

/**
 * 教育经历Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
public interface SysEduMapper 
{
    /**
     * 查询教育经历
     * 
     * @param eduId 教育经历主键
     * @return 教育经历
     */
    public SysEdu selectSysEduByEduId(Long eduId);

    /**
     * 查询教育经历列表
     * 
     * @param sysEdu 教育经历
     * @return 教育经历集合
     */
    public List<SysEdu> selectSysEduList(SysEdu sysEdu);

    /**
     * 新增教育经历
     * 
     * @param sysEdu 教育经历
     * @return 结果
     */
    public int insertSysEdu(SysEdu sysEdu);

    /**
     * 修改教育经历
     * 
     * @param sysEdu 教育经历
     * @return 结果
     */
    public int updateSysEdu(SysEdu sysEdu);

    /**
     * 删除教育经历
     * 
     * @param eduId 教育经历主键
     * @return 结果
     */
    public int deleteSysEduByEduId(Long eduId);

    /**
     * 批量删除教育经历
     * 
     * @param eduIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysEduByEduIds(Long[] eduIds);

    public int deleteSysEduByPersonnelId(Long personnelId);
}
