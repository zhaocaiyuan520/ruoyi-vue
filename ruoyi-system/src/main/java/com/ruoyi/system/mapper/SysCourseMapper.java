package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCourse;

/**
 * 课件Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-16
 */
public interface SysCourseMapper 
{
    /**
     * 查询课件
     * 
     * @param courseId 课件主键
     * @return 课件
     */
    public SysCourse selectSysCourseByCourseId(Long courseId);

    /**
     * 查询课件列表
     * 
     * @param sysCourse 课件
     * @return 课件集合
     */
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse);

    /**
     * 新增课件
     * 
     * @param sysCourse 课件
     * @return 结果
     */
    public int insertSysCourse(SysCourse sysCourse);

    /**
     * 修改课件
     * 
     * @param sysCourse 课件
     * @return 结果
     */
    public int updateSysCourse(SysCourse sysCourse);

    /**
     * 删除课件
     * 
     * @param courseId 课件主键
     * @return 结果
     */
    public int deleteSysCourseByCourseId(Long courseId);

    /**
     * 批量删除课件
     * 
     * @param courseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCourseByCourseIds(Long[] courseIds);
}
