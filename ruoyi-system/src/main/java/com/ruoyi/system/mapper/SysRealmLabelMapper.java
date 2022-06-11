package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRealmLabel;

/**
 * 领域标签Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
public interface SysRealmLabelMapper 
{
    /**
     * 查询领域标签
     * 
     * @param labelId 领域标签主键
     * @return 领域标签
     */
    public SysRealmLabel selectSysRealmLabelByLabelId(Long labelId);

    /**
     * 查询领域标签列表
     * 
     * @param sysRealmLabel 领域标签
     * @return 领域标签集合
     */
    public List<SysRealmLabel> selectSysRealmLabelList(SysRealmLabel sysRealmLabel);

    /**
     * 新增领域标签
     * 
     * @param sysRealmLabel 领域标签
     * @return 结果
     */
    public int insertSysRealmLabel(SysRealmLabel sysRealmLabel);

    /**
     * 修改领域标签
     * 
     * @param sysRealmLabel 领域标签
     * @return 结果
     */
    public int updateSysRealmLabel(SysRealmLabel sysRealmLabel);

    /**
     * 删除领域标签
     * 
     * @param labelId 领域标签主键
     * @return 结果
     */
    public int deleteSysRealmLabelByLabelId(Long labelId);

    /**
     * 批量删除领域标签
     * 
     * @param labelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRealmLabelByLabelIds(Long[] labelIds);
}
