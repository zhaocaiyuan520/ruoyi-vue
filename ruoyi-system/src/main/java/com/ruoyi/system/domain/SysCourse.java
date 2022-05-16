package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课件对象 sys_course
 *
 * @author ruoyi
 * @date 2022-05-16
 */
public class SysCourse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课件id
     */
    private Long courseId;

    /**
     * 课件名称中文
     */
    @Excel(name = "课件名称中文")
    private String courseName;

    /**
     * 课件名称中文
     */
    @Excel(name = "课件名称中文")
    private String courseNameen;

    /**
     * 课件介绍中文
     */
    @Excel(name = "课件介绍中文")
    private String courseIntroduce;

    /**
     * 课件介绍英文
     */
    @Excel(name = "课件介绍英文")
    private String courseIntroduceen;

    /**
     * 0:本科生课程，1：研究生课程
     */
    @Excel(name = "0:本科生课程，1：研究生课程")
    private String courseType;

    /**
     * 文件id
     */
    @Excel(name = "文件id")
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
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseNameen(String courseNameen) {
        this.courseNameen = courseNameen;
    }

    public String getCourseNameen() {
        return courseNameen;
    }

    public void setCourseIntroduce(String courseIntroduce) {
        this.courseIntroduce = courseIntroduce;
    }

    public String getCourseIntroduce() {
        return courseIntroduce;
    }

    public void setCourseIntroduceen(String courseIntroduceen) {
        this.courseIntroduceen = courseIntroduceen;
    }

    public String getCourseIntroduceen() {
        return courseIntroduceen;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("courseId", getCourseId())
                .append("courseName", getCourseName())
                .append("courseNameen", getCourseNameen())
                .append("courseIntroduce", getCourseIntroduce())
                .append("courseIntroduceen", getCourseIntroduceen())
                .append("courseType", getCourseType())
                .append("fileId", getFileId())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }


}
