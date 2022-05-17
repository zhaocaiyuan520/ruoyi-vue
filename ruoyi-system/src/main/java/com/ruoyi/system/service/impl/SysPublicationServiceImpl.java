package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.mapper.SysFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPublicationMapper;
import com.ruoyi.system.domain.SysPublication;
import com.ruoyi.system.service.ISysPublicationService;
import org.springframework.util.CollectionUtils;

/**
 * 出版物模块详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-13
 */
@Service
public class SysPublicationServiceImpl implements ISysPublicationService {
    @Autowired
    private SysPublicationMapper sysPublicationMapper;
    @Autowired
    private SysFileMapper sysFileMapper;

    /**
     * 查询出版物模块详情
     *
     * @param id 出版物模块详情主键
     * @return 出版物模块详情
     */
    @Override
    public SysPublication selectSysPublicationById(Long id) {
        SysPublication sysPublication = sysPublicationMapper.selectSysPublicationById(id);
        if (sysPublication != null) {

            List<SysFileData> sysFileData = sysFileMapper.querySysFileList(new SysFileData());
            Map<Long, SysFileData> map = sysFileData.stream().collect(Collectors.toMap(SysFileData::getFileId, Function.identity()));
            SysFileData imgFile = map.get(sysPublication.getImgId());
            SysFileData pdfFile = map.get(sysPublication.getPdfId());

            sysPublication.setImgName(imgFile.getRealName());
            sysPublication.setImgAddress(imgFile.getFilePath());

            sysPublication.setPdfName(pdfFile.getRealName());
            sysPublication.setPdfAddress(pdfFile.getFilePath());
        }
        return sysPublication;
    }

    /**
     * 查询出版物模块详情列表
     *
     * @param sysPublication 出版物模块详情
     * @return 出版物模块详情
     */
    @Override
    public List<SysPublication> selectSysPublicationList(SysPublication sysPublication) {
        List<SysPublication> sysPublications = sysPublicationMapper.selectSysPublicationList(sysPublication);

        if (!CollectionUtils.isEmpty(sysPublications)) {
            List<SysFileData> sysFileData = sysFileMapper.querySysFileList(new SysFileData());
            Map<Long, SysFileData> map = sysFileData.stream().collect(Collectors.toMap(SysFileData::getFileId, Function.identity()));
            for (SysPublication publication : sysPublications) {
                SysFileData imgFile = map.get(publication.getImgId());
                SysFileData pdfFile = map.get(publication.getPdfId());

                publication.setImgName(imgFile != null ? imgFile.getRealName() : "");
                publication.setImgAddress(imgFile != null ? imgFile.getFilePath() : "");

                publication.setPdfName(pdfFile != null ? pdfFile.getRealName() : "");
                publication.setPdfAddress(pdfFile != null ? pdfFile.getFilePath() : "");
            }
        }


        return sysPublications;
    }

    /**
     * 新增出版物模块详情
     *
     * @param sysPublication 出版物模块详情
     * @return 结果
     */
    @Override
    public int insertSysPublication(SysPublication sysPublication) {
        sysPublication.setCreateTime(DateUtils.getNowDate());
        return sysPublicationMapper.insertSysPublication(sysPublication);

//        // 状态 临时文件 ，修改为轮播图新增确定后的状态 模板文件
//        if (sysPublication.getImgId() != null) {
//            SysFileData sysFileData = new SysFileData();
//            sysFileData.setFileId(sysPublication.getImgId());
//            sysFileData.setUpdateTime(new Date());
//            sysFileData.setFileFlag("1");
//            sysFileMapper.updateSysFile(sysFileData);
//        }
//        if (sysPublication.getPdfId() != null) {
//            SysFileData sysFileData = new SysFileData();
//            sysFileData.setFileId(sysPublication.getPdfId());
//            sysFileData.setUpdateTime(new Date());
//            sysFileData.setFileFlag("1");
//            sysFileMapper.updateSysFile(sysFileData);
//        }
//
//        return 1;

    }

    /**
     * 修改出版物模块详情
     *
     * @param sysPublication 出版物模块详情
     * @return 结果
     */
    @Override
    public int updateSysPublication(SysPublication sysPublication) {
        sysPublication.setUpdateTime(DateUtils.getNowDate());
        return sysPublicationMapper.updateSysPublication(sysPublication);
    }

    /**
     * 批量删除出版物模块详情
     *
     * @param ids 需要删除的出版物模块详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPublicationByIds(Long[] ids) {


        return sysPublicationMapper.deleteSysPublicationByIds(ids);
    }

    /**
     * 删除出版物模块详情信息
     *
     * @param id 出版物模块详情主键
     * @return 结果
     */
    @Override
    public int deleteSysPublicationById(Long id) {
        return sysPublicationMapper.deleteSysPublicationById(id);
    }
}
