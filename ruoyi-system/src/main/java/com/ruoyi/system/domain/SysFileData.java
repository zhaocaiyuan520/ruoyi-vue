package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author: CTX
 * @Date: 2022/05/11/9:13
 * @Description:
 */
public class SysFileData extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 轮播图 id
     */
    private Long fileId;


    /**
     * 文件路径
     */
    @Excel(name = "文件路径")
    private String filePath;

    /**
     * 真实名称
     */
    @Excel(name = "真实名称")
    private String realName;

    /**
     * 0:首页轮播图，1：PDF文章
     */
    @Excel(name = "0:首页轮播图，1：PDF文章")
    private String fileType;




    /**
     *  0：临时文件，1：模板文件
     */
    @Excel(name = " 0：临时文件，1：模板文件")
    private String fileFlag;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileFlag() {
        return fileFlag;
    }

    public void setFileFlag(String fileFlag) {
        this.fileFlag = fileFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
