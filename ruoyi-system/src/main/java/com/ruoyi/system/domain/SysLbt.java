package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轮播图对象 sys_lbt
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
public class SysLbt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图 id */
    private Long lbtId;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 真实名称 */
    @Excel(name = "真实名称")
    private String realName;

    /** 地址名称 */
    @Excel(name = "地址名称")
    private String fileName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 0:首页轮播图，1：PDF文章 */
    @Excel(name = "0:首页轮播图，1：PDF文章")
    private String fileType;

    /** 0：临时文件，1：模板文件 */
    @Excel(name = "0：临时文件，1：模板文件")
    private String fileFlag;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setLbtId(Long lbtId) 
    {
        this.lbtId = lbtId;
    }

    public Long getLbtId() 
    {
        return lbtId;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setOrderNum(Integer orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() 
    {
        return orderNum;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFileFlag(String fileFlag) 
    {
        this.fileFlag = fileFlag;
    }

    public String getFileFlag() 
    {
        return fileFlag;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lbtId", getLbtId())
            .append("filePath", getFilePath())
            .append("realName", getRealName())
            .append("fileName", getFileName())
            .append("orderNum", getOrderNum())
            .append("fileType", getFileType())
            .append("fileFlag", getFileFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
