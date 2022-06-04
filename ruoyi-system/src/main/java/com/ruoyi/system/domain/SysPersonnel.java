package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 人员详情对象 sys_personnel
 * 
 * @author ruoyi
 * @date 2022-05-17
 */
public class SysPersonnel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人员id */
    private Long personnelId;

    /** 0:博导、1:博士、2:研究生 */
    @Excel(name = "0:博导、1:博士、2:研究生")
    private String personnelType;

    /** 头像id，文件表存储地址和名称 */
    @Excel(name = "头像id，文件表存储地址和名称")
    private Long fileId;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 真实名称 */
    @Excel(name = "真实名称")
    private String realName;

    /** 姓名中文 */
    @Excel(name = "姓名中文")
    private String personnelName;

    /** 姓名英文 */
    @Excel(name = "姓名英文")
    private String personnelNameen;

    /** 简介中文 */
    @Excel(name = "简介中文")
    private String personnelIntroduce;

    /** 简介英文 */
    @Excel(name = "简介英文")
    private String personnelIntroduceen;

    /** 地址中文 */
    @Excel(name = "地址中文")
    private String personnelAddress;

    /** 地址中文 */
    @Excel(name = "地址中文")
    private String personnelAddressen;

    /** labs */
    @Excel(name = "labs")
    private String labs;

    /** offices */
    @Excel(name = "offices")
    private String offices;


    /** Tel号码 */
    @Excel(name = "Tel号码")
    private String telNumber;

    /** Fax号码 */
    @Excel(name = "Fax号码")
    private String faxNumber;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 推特 */
    @Excel(name = "推特")
    private String twitter;

    /** linked */
    @Excel(name = "linked")
    private String linkedin;

    /** 人员日期 */
    @Excel(name = "人员日期")
    private String personnelDate;

    /** 当前位置 */
    @Excel(name = "当前位置")
    private String currentPosition;

    /** 当前位置 */
    @Excel(name = "当前位置")
    private String currentPositionen;

    /** 0:在读，1：已毕业 */
    @Excel(name = "0:在读，1：已毕业")
    private String graduateType;

    /** 团队成员 0:是，1：不是 */
    @Excel(name = "0:在读，1：已毕业")
    private String teamType;

    /** contact中文 */
    @Excel(name = "contact中文")
    private String personnelContact;

    /** contact英文 */
    @Excel(name = "contact英文")
    private String personnelContacten;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /**
     *教育经历
     */
    private List<SysEdu> eduList;

    public void setPersonnelId(Long personnelId) 
    {
        this.personnelId = personnelId;
    }

    public Long getPersonnelId() 
    {
        return personnelId;
    }
    public void setPersonnelType(String personnelType) 
    {
        this.personnelType = personnelType;
    }

    public String getPersonnelType() 
    {
        return personnelType;
    }
    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setPersonnelName(String personnelName) 
    {
        this.personnelName = personnelName;
    }

    public String getPersonnelName() 
    {
        return personnelName;
    }
    public void setPersonnelNameen(String personnelNameen) 
    {
        this.personnelNameen = personnelNameen;
    }

    public String getPersonnelNameen() 
    {
        return personnelNameen;
    }
    public void setPersonnelIntroduce(String personnelIntroduce) 
    {
        this.personnelIntroduce = personnelIntroduce;
    }

    public String getPersonnelIntroduce() 
    {
        return personnelIntroduce;
    }
    public void setPersonnelIntroduceen(String personnelIntroduceen) 
    {
        this.personnelIntroduceen = personnelIntroduceen;
    }

    public String getPersonnelIntroduceen() 
    {
        return personnelIntroduceen;
    }
    public void setPersonnelAddress(String personnelAddress) 
    {
        this.personnelAddress = personnelAddress;
    }

    public String getPersonnelAddress() 
    {
        return personnelAddress;
    }
    public void setPersonnelAddressen(String personnelAddressen) 
    {
        this.personnelAddressen = personnelAddressen;
    }

    public String getPersonnelAddressen() 
    {
        return personnelAddressen;
    }
    public void setTelNumber(String telNumber) 
    {
        this.telNumber = telNumber;
    }

    public String getTelNumber() 
    {
        return telNumber;
    }
    public void setFaxNumber(String faxNumber) 
    {
        this.faxNumber = faxNumber;
    }

    public String getFaxNumber() 
    {
        return faxNumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setTwitter(String twitter) 
    {
        this.twitter = twitter;
    }

    public String getTwitter() 
    {
        return twitter;
    }
    public void setLinkedin(String linkedin) 
    {
        this.linkedin = linkedin;
    }

    public String getLinkedin() 
    {
        return linkedin;
    }
    public void setPersonnelDate(String personnelDate) 
    {
        this.personnelDate = personnelDate;
    }

    public String getPersonnelDate() 
    {
        return personnelDate;
    }
    public void setCurrentPosition(String currentPosition) 
    {
        this.currentPosition = currentPosition;
    }

    public String getCurrentPosition() 
    {
        return currentPosition;
    }
    public void setCurrentPositionen(String currentPositionen) 
    {
        this.currentPositionen = currentPositionen;
    }

    public String getCurrentPositionen() 
    {
        return currentPositionen;
    }
    public void setGraduateType(String graduateType) 
    {
        this.graduateType = graduateType;
    }

    public String getGraduateType() 
    {
        return graduateType;
    }
    public void setPersonnelContact(String personnelContact) 
    {
        this.personnelContact = personnelContact;
    }

    public String getPersonnelContact() 
    {
        return personnelContact;
    }
    public void setPersonnelContacten(String personnelContacten) 
    {
        this.personnelContacten = personnelContacten;
    }

    public String getPersonnelContacten() 
    {
        return personnelContacten;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public List<SysEdu> getEduList() {
        return eduList;
    }

    public void setEduList(List<SysEdu> eduList) {
        this.eduList = eduList;
    }

    public String getLabs() {
        return labs;
    }

    public void setLabs(String labs) {
        this.labs = labs;
    }

    public String getOffices() {
        return offices;
    }

    public void setOffices(String offices) {
        this.offices = offices;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("personnelId", getPersonnelId())
            .append("personnelType", getPersonnelType())
            .append("fileId", getFileId())
            .append("personnelName", getPersonnelName())
            .append("personnelNameen", getPersonnelNameen())
            .append("personnelIntroduce", getPersonnelIntroduce())
            .append("personnelIntroduceen", getPersonnelIntroduceen())
            .append("personnelAddress", getPersonnelAddress())
            .append("personnelAddressen", getPersonnelAddressen())
            .append("labs", getLabs())
            .append("offices", getOffices())
            .append("telNumber", getTelNumber())
            .append("faxNumber", getFaxNumber())
            .append("email", getEmail())
            .append("twitter", getTwitter())
            .append("linkedin", getLinkedin())
            .append("personnelDate", getPersonnelDate())
            .append("currentPosition", getCurrentPosition())
            .append("currentPositionen", getCurrentPositionen())
            .append("graduateType", getGraduateType())
            .append("personnelContact", getPersonnelContact())
            .append("personnelContacten", getPersonnelContacten())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
