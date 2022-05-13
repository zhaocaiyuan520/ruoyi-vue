package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出版物模块详情对象 sys_publication
 * 
 * @author ruoyi
 * @date 2022-05-13
 */
public class SysPublication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文献id */
    private Long id;

    /** 文献年份 */
    @Excel(name = "文献年份")
    private String year;

    /** 文献标题中文 */
    @Excel(name = "文献标题中文")
    private String literatureTitle;

    /** 文献标题英文 */
    @Excel(name = "文献标题英文")
    private String literatureTitleen;

    /** 文献pdfId */
    @Excel(name = "文献pdfId")
    private Long pdfId;

    /** 文献图片Id */
    @Excel(name = "文献图片Id")
    private Long imgId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setYear(String year) 
    {
        this.year = year;
    }

    public String getYear() 
    {
        return year;
    }
    public void setLiteratureTitle(String literatureTitle) 
    {
        this.literatureTitle = literatureTitle;
    }

    public String getLiteratureTitle() 
    {
        return literatureTitle;
    }
    public void setLiteratureTitleen(String literatureTitleen) 
    {
        this.literatureTitleen = literatureTitleen;
    }

    public String getLiteratureTitleen() 
    {
        return literatureTitleen;
    }
    public void setPdfId(Long pdfId) 
    {
        this.pdfId = pdfId;
    }

    public Long getPdfId() 
    {
        return pdfId;
    }
    public void setImgId(Long imgId) 
    {
        this.imgId = imgId;
    }

    public Long getImgId() 
    {
        return imgId;
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
            .append("id", getId())
            .append("year", getYear())
            .append("literatureTitle", getLiteratureTitle())
            .append("literatureTitleen", getLiteratureTitleen())
            .append("pdfId", getPdfId())
            .append("imgId", getImgId())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
