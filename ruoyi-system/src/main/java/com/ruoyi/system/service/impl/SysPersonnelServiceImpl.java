package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysEdu;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.mapper.SysEduMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPersonnelMapper;
import com.ruoyi.system.domain.SysPersonnel;
import com.ruoyi.system.service.ISysPersonnelService;

/**
 * 人员详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-17
 */
@Service
public class SysPersonnelServiceImpl implements ISysPersonnelService {
    @Autowired
    private SysPersonnelMapper sysPersonnelMapper;
    @Autowired
    private SysEduMapper sysEduMapper;

    /**
     * 查询人员详情
     *
     * @param personnelId 人员详情主键
     * @return 人员详情
     */
    @Override
    public SysPersonnel selectSysPersonnelByPersonnelId(Long personnelId) {
        SysPersonnel sysPersonnel = sysPersonnelMapper.selectSysPersonnelByPersonnelId(personnelId);

        //查询教育经历信息
        SysEdu sysEdu = new SysEdu();
        sysEdu.setPersonnelId(personnelId);
        List<SysEdu> sysEdus = sysEduMapper.selectSysEduList(sysEdu);
        if(sysPersonnel!=null){
            sysPersonnel.setEduList(sysEdus);
        }

        return sysPersonnel;
    }

    /**
     * 查询人员详情列表
     *
     * @param sysPersonnel 人员详情
     * @return 人员详情
     */
    @Override
    public List<SysPersonnel> selectSysPersonnelList(SysPersonnel sysPersonnel) {
        List<SysPersonnel> sysPersonnels = sysPersonnelMapper.selectSysPersonnelList(sysPersonnel);

        for (SysPersonnel personnel : sysPersonnels) {
            Long personnelId = personnel.getPersonnelId();
            SysEdu sysEdu = new SysEdu();
            sysEdu.setPersonnelId(personnelId);
            List<SysEdu> sysEdus = sysEduMapper.selectSysEduList(sysEdu);
            personnel.setEduList(sysEdus);
        }
        return sysPersonnels;
    }

    /**
     * 新增人员详情
     *
     * @param sysPersonnel 人员详情
     * @return 结果
     */
    @Override
    public int insertSysPersonnel(SysPersonnel sysPersonnel) {
        sysPersonnel.setCreateTime(DateUtils.getNowDate());
        sysPersonnelMapper.insertSysPersonnel(sysPersonnel);
        Long sysPersonnelId = sysPersonnel.getPersonnelId();
        return sysPersonnelId.intValue();
    }

    /**
     * 修改人员详情
     *
     * @param sysPersonnel 人员详情
     * @return 结果
     */
    @Override
    public int updateSysPersonnel(SysPersonnel sysPersonnel) {
        sysPersonnel.setUpdateTime(DateUtils.getNowDate());
        return sysPersonnelMapper.updateSysPersonnel(sysPersonnel);
    }

    /**
     * 批量删除人员详情
     *
     * @param personnelIds 需要删除的人员详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonnelByPersonnelIds(Long[] personnelIds) {
        return sysPersonnelMapper.deleteSysPersonnelByPersonnelIds(personnelIds);
    }

    /**
     * 删除人员详情信息
     *
     * @param personnelId 人员详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonnelByPersonnelId(Long personnelId) {
        return sysPersonnelMapper.deleteSysPersonnelByPersonnelId(personnelId);
    }
}
