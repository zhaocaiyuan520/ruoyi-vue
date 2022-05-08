package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 主页详情对象 sys_home_article
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
public class SysHomeArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 首页文章id */
    private Long articleId;

    /** 0:产品，1：流程，2：知识，3：项目管理 */
    @Excel(name = "0:产品，1：流程，2：知识，3：项目管理")
    private String articleType;

    /** 文章名称 */
    @Excel(name = "文章名称")
    private String articleName;

    /** 文章名称英文 */
    @Excel(name = "文章名称英文")
    private String articleNameen;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件id */
    @Excel(name = "文件id")
    private Long fileId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }
    public void setArticleType(String articleType) 
    {
        this.articleType = articleType;
    }

    public String getArticleType() 
    {
        return articleType;
    }
    public void setArticleName(String articleName) 
    {
        this.articleName = articleName;
    }

    public String getArticleName() 
    {
        return articleName;
    }
    public void setArticleNameen(String articleNameen) 
    {
        this.articleNameen = articleNameen;
    }

    public String getArticleNameen() 
    {
        return articleNameen;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
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
            .append("articleId", getArticleId())
            .append("articleType", getArticleType())
            .append("articleName", getArticleName())
            .append("articleNameen", getArticleNameen())
            .append("fileName", getFileName())
            .append("fileId", getFileId())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
