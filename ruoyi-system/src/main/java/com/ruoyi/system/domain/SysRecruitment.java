package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 招聘对象 sys_recruitment
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
public class SysRecruitment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招聘id */
    private Long recruitId;

    /** 招聘职位中文 */
    @Excel(name = "招聘职位中文")
    private String recruitPosition;

    /** 招聘职位英文 */
    @Excel(name = "招聘职位英文")
    private String recruitPositionen;

    /** 招聘描述中文 */
    @Excel(name = "招聘描述中文")
    private String recruitDescribe;

    /** 招聘描述英文 */
    @Excel(name = "招聘描述英文")
    private String recruitDescribeen;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setRecruitId(Long recruitId) 
    {
        this.recruitId = recruitId;
    }

    public Long getRecruitId() 
    {
        return recruitId;
    }
    public void setRecruitPosition(String recruitPosition) 
    {
        this.recruitPosition = recruitPosition;
    }

    public String getRecruitPosition() 
    {
        return recruitPosition;
    }
    public void setRecruitPositionen(String recruitPositionen) 
    {
        this.recruitPositionen = recruitPositionen;
    }

    public String getRecruitPositionen() 
    {
        return recruitPositionen;
    }
    public void setRecruitDescribe(String recruitDescribe) 
    {
        this.recruitDescribe = recruitDescribe;
    }

    public String getRecruitDescribe() 
    {
        return recruitDescribe;
    }
    public void setRecruitDescribeen(String recruitDescribeen) 
    {
        this.recruitDescribeen = recruitDescribeen;
    }

    public String getRecruitDescribeen() 
    {
        return recruitDescribeen;
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
            .append("recruitId", getRecruitId())
            .append("recruitPosition", getRecruitPosition())
            .append("recruitPositionen", getRecruitPositionen())
            .append("recruitDescribe", getRecruitDescribe())
            .append("recruitDescribeen", getRecruitDescribeen())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
