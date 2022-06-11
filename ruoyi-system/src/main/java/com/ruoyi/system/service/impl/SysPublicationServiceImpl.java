package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysFileData;
import com.ruoyi.system.domain.SysRealmLabel;
import com.ruoyi.system.mapper.SysFileMapper;
import com.ruoyi.system.mapper.SysRealmLabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPublicationMapper;
import com.ruoyi.system.domain.SysPublication;
import com.ruoyi.system.service.ISysPublicationService;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private SysRealmLabelMapper sysRealmLabelMapper;
    /**
     * 查询出版物模块详情
     *
     * @param id 出版物模块详情主键
     * @return 出版物模块详情
     */
    @Override
    public SysPublication selectSysPublicationById(Long id) {
        SysPublication sysPublication = sysPublicationMapper.selectSysPublicationById(id);
        //领域标签
        List<SysRealmLabel> sysRealmLabels = sysRealmLabelMapper.selectSysRealmLabelList(new SysRealmLabel());
        Map<Long,List<SysRealmLabel>> labelMap = sysRealmLabels.stream().collect(Collectors.groupingBy(SysRealmLabel::getPublicationId));

        if (sysPublication != null) {

            List<SysFileData> sysFileData = sysFileMapper.querySysFileList(new SysFileData());
            Map<Long, SysFileData> map = sysFileData.stream().collect(Collectors.toMap(SysFileData::getFileId, Function.identity()));
            SysFileData imgFile = map.get(sysPublication.getImgId());
            SysFileData pdfFile = map.get(sysPublication.getPdfId());

            if(imgFile!=null){
                sysPublication.setImgName(imgFile.getRealName());
                sysPublication.setImgAddress(imgFile.getFilePath());
            }else {
                sysPublication.setImgName("");
                sysPublication.setImgAddress("");
            }

            if(pdfFile!=null){
                sysPublication.setPdfName(pdfFile.getRealName());
                sysPublication.setPdfAddress(pdfFile.getFilePath());
            }else{
                sysPublication.setPdfName("");
                sysPublication.setPdfAddress("");
            }

            //设置领域标签
            List<SysRealmLabel> sysRealmLabel = labelMap.get(sysPublication.getId());
            if(sysRealmLabel!=null){
                List<String> labelList = sysRealmLabel.stream().map(SysRealmLabel::getLabelType).collect(Collectors.toList());
                sysPublication.setLabelList(labelList);
            }else{
                sysPublication.setLabelList(new ArrayList<>());

            }


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
            //文件 id
            List<SysFileData> sysFileData = sysFileMapper.querySysFileList(new SysFileData());
            Map<Long, SysFileData> map = sysFileData.stream().collect(Collectors.toMap(SysFileData::getFileId, Function.identity()));
            //领域标签
            List<SysRealmLabel> sysRealmLabels = sysRealmLabelMapper.selectSysRealmLabelList(new SysRealmLabel());
            Map<Long,List<SysRealmLabel>> labelMap = sysRealmLabels.stream().collect(Collectors.groupingBy(SysRealmLabel::getPublicationId));

            for (SysPublication publication : sysPublications) {
                SysFileData imgFile = map.get(publication.getImgId());
                SysFileData pdfFile = map.get(publication.getPdfId());

                publication.setImgName(imgFile != null ? imgFile.getRealName() : "");
                publication.setImgAddress(imgFile != null ? imgFile.getFilePath() : "");

                publication.setPdfName(pdfFile != null ? pdfFile.getRealName() : "");
                publication.setPdfAddress(pdfFile != null ? pdfFile.getFilePath() : "");

                //设置领域标签
                List<SysRealmLabel> sysRealmLabel = labelMap.get(publication.getId());
                if(!CollectionUtils.isEmpty(sysRealmLabel)){
                    List<String> labelList = sysRealmLabel.stream().map(SysRealmLabel::getLabelType).collect(Collectors.toList());
                    publication.setLabelList(labelList);
                }

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
          sysPublicationMapper.insertSysPublication(sysPublication);
        int id = sysPublication.getId().intValue();
        insertLable(sysPublication, Long.valueOf(id));
        return id;

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

    private void insertLable(SysPublication sysPublication, Long id) {
        List<String> labelList = sysPublication.getLabelList();
        if(!CollectionUtils.isEmpty(labelList)) {
            //维护领域标签
            for (String labelType : labelList) {
                SysRealmLabel sysReal = new SysRealmLabel();
                sysReal.setPublicationId(id);
                sysReal.setLabelType(labelType);
                sysRealmLabelMapper.insertSysRealmLabel(sysReal);
            }
        }
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
        sysPublicationMapper.updateSysPublication(sysPublication);
        //根据id查询标签
        Long publicationId = sysPublication.getId();
        //根据id删除领域标签
        delLabelById(publicationId);
        //然后在新增
        insertLable(sysPublication,publicationId);
        return 1;
    }

    private void delLabelById(Long publicationId) {
        SysRealmLabel sysLabel = new SysRealmLabel();
        sysLabel.setPublicationId(publicationId);
        List<SysRealmLabel> sysRealmLabels = sysRealmLabelMapper.selectSysRealmLabelList(sysLabel);

        List<Long> collect = sysRealmLabels.stream().map(sysRealmLabel -> sysRealmLabel.getLabelId()).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(collect)) {
            Long[] ids = new Long[collect.size()];
            ids = collect.toArray(ids);
            //删除标签内
            sysRealmLabelMapper.deleteSysRealmLabelByLabelIds(ids);
        }
    }

    /**
     * 批量删除出版物模块详情
     *
     * @param ids 需要删除的出版物模块详情主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysPublicationByIds(Long[] ids) {
        //删除标签
        for (Long id : ids) {
            delLabelById(id);
        }

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
