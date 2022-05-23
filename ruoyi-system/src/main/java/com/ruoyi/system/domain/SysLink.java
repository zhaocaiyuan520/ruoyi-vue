package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 链接对象 sys_link
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
public class SysLink extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 链接id */
    private Long linkId;

    /** 链接标题中文 */
    @Excel(name = "链接标题中文")
    private String linkTitle;

    /** 链接标题英文 */
    @Excel(name = "链接标题英文")
    private String linkTitleen;

    /** 链接URL地址 */
    @Excel(name = "链接URL地址")
    private String linkUrl;

    /** 0:penn;1:meeting;2:journals */
    @Excel(name = "0:penn;1:meeting;2:journals")
    private String linkType;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setLinkId(Long linkId) 
    {
        this.linkId = linkId;
    }

    public Long getLinkId() 
    {
        return linkId;
    }
    public void setLinkTitle(String linkTitle) 
    {
        this.linkTitle = linkTitle;
    }

    public String getLinkTitle() 
    {
        return linkTitle;
    }
    public void setLinkTitleen(String linkTitleen) 
    {
        this.linkTitleen = linkTitleen;
    }

    public String getLinkTitleen() 
    {
        return linkTitleen;
    }
    public void setLinkUrl(String linkUrl) 
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() 
    {
        return linkUrl;
    }
    public void setLinkType(String linkType) 
    {
        this.linkType = linkType;
    }

    public String getLinkType() 
    {
        return linkType;
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
            .append("linkId", getLinkId())
            .append("linkTitle", getLinkTitle())
            .append("linkTitleen", getLinkTitleen())
            .append("linkUrl", getLinkUrl())
            .append("linkType", getLinkType())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
