package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysPublication;
import com.ruoyi.system.mapper.SysFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCourseMapper;
import com.ruoyi.system.domain.SysCourse;
import com.ruoyi.system.service.ISysCourseService;
import org.springframework.util.CollectionUtils;

/**
 * 课件Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-16
 */
@Service
public class SysCourseServiceImpl implements ISysCourseService {
    @Autowired
    private SysCourseMapper sysCourseMapper;
    @Autowired
    private SysFileMapper sysFileMapper;

    /**
     * 查询课件
     *
     * @param courseId 课件主键
     * @return 课件
     */
    @Override
    public SysCourse selectSysCourseByCourseId(Long courseId) {
        SysCourse sysCourse = sysCourseMapper.selectSysCourseByCourseId(courseId);

        if (sysCourse!=null) {
            List<SysFileData> sysFileData = sysFileMapper.querySysFileList(new SysFileData());
            Map<Long, SysFileData> map = sysFileData.stream().collect(Collectors.toMap(SysFileData::getFileId, Function.identity()));
            SysFileData fileData = map.get(sysCourse.getFileId());
            if (fileData != null) {
                sysCourse.setRealName(fileData.getRealName());
                sysCourse.setFilePath(fileData.getFilePath());
            }
        }

        return sysCourse;
    }

    /**
     * 查询课件列表
     *
     * @param sysCourse 课件
     * @return 课件
     */
    @Override
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse) {
        List<SysCourse> sysCourses = sysCourseMapper.selectSysCourseList(sysCourse);

        if (!CollectionUtils.isEmpty(sysCourses)) {
            List<SysFileData> sysFileData = sysFileMapper.querySysFileList(new SysFileData());
            Map<Long, SysFileData> map = sysFileData.stream().collect(Collectors.toMap(SysFileData::getFileId, Function.identity()));
            for (SysCourse course : sysCourses) {
                SysFileData fileData = map.get(course.getFileId());
                if (fileData != null) {
                    course.setRealName(fileData.getRealName());
                    course.setFilePath(fileData.getFilePath());
                }
            }
        }

        return sysCourses;
    }

    /**
     * 新增课件
     *
     * @param sysCourse 课件
     * @return 结果
     */
    @Override
    public int insertSysCourse(SysCourse sysCourse) {
        sysCourse.setCreateTime(DateUtils.getNowDate());
        return sysCourseMapper.insertSysCourse(sysCourse);
    }

    /**
     * 修改课件
     *
     * @param sysCourse 课件
     * @return 结果
     */
    @Override
    public int updateSysCourse(SysCourse sysCourse) {
        sysCourse.setUpdateTime(DateUtils.getNowDate());
        return sysCourseMapper.updateSysCourse(sysCourse);
    }

    /**
     * 批量删除课件
     *
     * @param courseIds 需要删除的课件主键
     * @return 结果
     */
    @Override
    public int deleteSysCourseByCourseIds(Long[] courseIds) {
        return sysCourseMapper.deleteSysCourseByCourseIds(courseIds);
    }

    /**
     * 删除课件信息
     *
     * @param courseId 课件主键
     * @return 结果
     */
    @Override
    public int deleteSysCourseByCourseId(Long courseId) {
        return sysCourseMapper.deleteSysCourseByCourseId(courseId);
    }
}
