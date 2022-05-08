package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 主页详情对象 sys_home_info
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
public class SysHomeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 首页详情id */
    private Long homeId;

    /** about中文 */
    @Excel(name = "about中文")
    private String homeAbout;

    /** about英文 */
    @Excel(name = "about英文")
    private String homeAbouten;

    /** research中文 */
    @Excel(name = "research中文")
    private String homeResearch;

    /** research英文 */
    @Excel(name = "research英文")
    private String homeResearchen;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setHomeId(Long homeId) 
    {
        this.homeId = homeId;
    }

    public Long getHomeId() 
    {
        return homeId;
    }
    public void setHomeAbout(String homeAbout) 
    {
        this.homeAbout = homeAbout;
    }

    public String getHomeAbout() 
    {
        return homeAbout;
    }
    public void setHomeAbouten(String homeAbouten) 
    {
        this.homeAbouten = homeAbouten;
    }

    public String getHomeAbouten() 
    {
        return homeAbouten;
    }
    public void setHomeResearch(String homeResearch) 
    {
        this.homeResearch = homeResearch;
    }

    public String getHomeResearch() 
    {
        return homeResearch;
    }
    public void setHomeResearchen(String homeResearchen) 
    {
        this.homeResearchen = homeResearchen;
    }

    public String getHomeResearchen() 
    {
        return homeResearchen;
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
            .append("homeId", getHomeId())
            .append("homeAbout", getHomeAbout())
            .append("homeAbouten", getHomeAbouten())
            .append("homeResearch", getHomeResearch())
            .append("homeResearchen", getHomeResearchen())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
