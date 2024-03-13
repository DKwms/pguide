package org.pguide.user.manage.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 usercenter_student_info
 * 
 * @author dkwms
 * @date 2024-01-02
 */
public class UsercenterStudentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long studentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String studentAccount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String studentPassword;

    /** 学号 */
    @Excel(name = "学号")
    private String workId;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String studentSex;

    /** 用户生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "用户生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date studentBirth;

    /** 用户手机号 */
    @Excel(name = "用户手机号")
    private Long studentPhonenumber;

    /** 用户邮箱号 */
    @Excel(name = "用户邮箱号")
    private String studentEmail;

    /** 用户学校 */
    @Excel(name = "用户学校")
    private String studentSchool;

    /** 用户学院 */
    @Excel(name = "用户学院")
    private String studentAcademy;

    /** 用户年级 */
    @Excel(name = "用户年级")
    private String studentYear;

    /** 用户专业 */
    @Excel(name = "用户专业")
    private String studentProfession;

    /** 用户个人签名 */
    @Excel(name = "用户个人签名")
    private String userSign;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    /** 逻辑删除 0删除状态 1没有删除 */
    @Excel(name = "逻辑删除 0删除状态 1没有删除")
    private Long deleted;

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setStudentAccount(String studentAccount) 
    {
        this.studentAccount = studentAccount;
    }

    public String getStudentAccount() 
    {
        return studentAccount;
    }
    public void setStudentPassword(String studentPassword) 
    {
        this.studentPassword = studentPassword;
    }

    public String getStudentPassword() 
    {
        return studentPassword;
    }
    public void setWorkId(String workId) 
    {
        this.workId = workId;
    }

    public String getWorkId() 
    {
        return workId;
    }
    public void setStudentSex(String studentSex) 
    {
        this.studentSex = studentSex;
    }

    public String getStudentSex() 
    {
        return studentSex;
    }
    public void setStudentBirth(Date studentBirth) 
    {
        this.studentBirth = studentBirth;
    }

    public Date getStudentBirth() 
    {
        return studentBirth;
    }
    public void setStudentPhonenumber(Long studentPhonenumber) 
    {
        this.studentPhonenumber = studentPhonenumber;
    }

    public Long getStudentPhonenumber() 
    {
        return studentPhonenumber;
    }
    public void setStudentEmail(String studentEmail) 
    {
        this.studentEmail = studentEmail;
    }

    public String getStudentEmail() 
    {
        return studentEmail;
    }
    public void setStudentSchool(String studentSchool) 
    {
        this.studentSchool = studentSchool;
    }

    public String getStudentSchool() 
    {
        return studentSchool;
    }
    public void setStudentAcademy(String studentAcademy) 
    {
        this.studentAcademy = studentAcademy;
    }

    public String getStudentAcademy() 
    {
        return studentAcademy;
    }
    public void setStudentYear(String studentYear) 
    {
        this.studentYear = studentYear;
    }

    public String getStudentYear() 
    {
        return studentYear;
    }
    public void setStudentProfession(String studentProfession) 
    {
        this.studentProfession = studentProfession;
    }

    public String getStudentProfession() 
    {
        return studentProfession;
    }
    public void setUserSign(String userSign) 
    {
        this.userSign = userSign;
    }

    public String getUserSign() 
    {
        return userSign;
    }
    public void setCreated(Date created) 
    {
        this.created = created;
    }

    public Date getCreated() 
    {
        return created;
    }
    public void setUpdated(Date updated) 
    {
        this.updated = updated;
    }

    public Date getUpdated() 
    {
        return updated;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("studentAccount", getStudentAccount())
            .append("studentPassword", getStudentPassword())
            .append("workId", getWorkId())
            .append("studentSex", getStudentSex())
            .append("studentBirth", getStudentBirth())
            .append("studentPhonenumber", getStudentPhonenumber())
            .append("studentEmail", getStudentEmail())
            .append("studentSchool", getStudentSchool())
            .append("studentAcademy", getStudentAcademy())
            .append("studentYear", getStudentYear())
            .append("studentProfession", getStudentProfession())
            .append("userSign", getUserSign())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
