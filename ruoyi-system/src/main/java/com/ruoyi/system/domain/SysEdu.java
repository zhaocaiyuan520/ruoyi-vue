package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教育经历对象 sys_edu
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
public class SysEdu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long eduId;

    /** 人员id */
    @Excel(name = "人员id")
    private Long personnelId;

    /** 教育经历中文 */
    @Excel(name = "教育经历中文")
    private String eduExperience;

    /** 教育经历英文 */
    @Excel(name = "教育经历英文")
    private String eduExperienceen;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setEduId(Long eduId) 
    {
        this.eduId = eduId;
    }

    public Long getEduId() 
    {
        return eduId;
    }
    public void setPersonnelId(Long personnelId) 
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId() 
    {
        return personnelId;
    }
    public void setEduExperience(String eduExperience) 
    {
        this.eduExperience = eduExperience;
    }

    public String getEduExperience() 
    {
        return eduExperience;
    }
    public void setEduExperienceen(String eduExperienceen) 
    {
        this.eduExperienceen = eduExperienceen;
    }

    public String getEduExperienceen() 
    {
        return eduExperienceen;
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
            .append("eduId", getEduId())
            .append("personnelId", getPersonnelId())
            .append("eduExperience", getEduExperience())
            .append("eduExperienceen", getEduExperienceen())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
