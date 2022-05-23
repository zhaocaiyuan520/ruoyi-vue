package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysRecruitment;

/**
 * 招聘Service接口
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
public interface ISysRecruitmentService 
{
    /**
     * 查询招聘
     * 
     * @param recruitId 招聘主键
     * @return 招聘
     */
    public SysRecruitment selectSysRecruitmentByRecruitId(Long recruitId);

    /**
     * 查询招聘列表
     * 
     * @param sysRecruitment 招聘
     * @return 招聘集合
     */
    public List<SysRecruitment> selectSysRecruitmentList(SysRecruitment sysRecruitment);

    /**
     * 新增招聘
     * 
     * @param sysRecruitment 招聘
     * @return 结果
     */
    public int insertSysRecruitment(SysRecruitment sysRecruitment);

    /**
     * 修改招聘
     * 
     * @param sysRecruitment 招聘
     * @return 结果
     */
    public int updateSysRecruitment(SysRecruitment sysRecruitment);

    /**
     * 批量删除招聘
     * 
     * @param recruitIds 需要删除的招聘主键集合
     * @return 结果
     */
    public int deleteSysRecruitmentByRecruitIds(Long[] recruitIds);

    /**
     * 删除招聘信息
     * 
     * @param recruitId 招聘主键
     * @return 结果
     */
    public int deleteSysRecruitmentByRecruitId(Long recruitId);
}
