package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 领域标签对象 sys_realm_label
 * 
 * @author ruoyi
 * @date 2022-06-11
 */
public class SysRealmLabel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签id */
    private Long labelId;

    /** 出版物id */
    @Excel(name = "出版物id")
    private Long publicationId;

    /** 领域标签 */
    @Excel(name = "领域标签")
    private String labelType;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setLabelId(Long labelId) 
    {
        this.labelId = labelId;
    }

    public Long getLabelId() 
    {
        return labelId;
    }
    public void setPublicationId(Long publicationId) 
    {
        this.publicationId = publicationId;
    }

    public Long getPublicationId() 
    {
        return publicationId;
    }
    public void setLabelType(String labelType) 
    {
        this.labelType = labelType;
    }

    public String getLabelType() 
    {
        return labelType;
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
            .append("labelId", getLabelId())
            .append("publicationId", getPublicationId())
            .append("labelType", getLabelType())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
