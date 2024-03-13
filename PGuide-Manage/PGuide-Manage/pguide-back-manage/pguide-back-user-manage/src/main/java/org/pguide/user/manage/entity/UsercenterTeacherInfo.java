package org.pguide.user.manage.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 usercenter_teacher_info
 * 
 * @author dkwms
 * @date 2024-01-02
 */
public class UsercenterTeacherInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Integer teacherId;

    /** 工号 */
    @Excel(name = "工号")
    private String workId;

    /** 用户账户 */
    @Excel(name = "用户账户")
    private String teacherAccount;

    /** 老师密码 */
    @Excel(name = "老师密码")
    private String teacherPassword;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String teacherSex;

    /** 用户生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "用户生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date teacherBirth;

    /** 用户手机号 */
    @Excel(name = "用户手机号")
    private Long teacherPhonenumber;

    /** 用户邮箱号 */
    @Excel(name = "用户邮箱号")
    private String teacherEmail;

    /** 用户单位 */
    @Excel(name = "用户单位")
    private String teacherUnit;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String teacherAcademy;

    /** 用户专业 */
    @Excel(name = "用户专业")
    private String teacherProfession;

    /** 用户个人签名 */
    @Excel(name = "用户个人签名")
    private String teacherSign;

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

    public void setTeacherId(Integer teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Integer getTeacherId() 
    {
        return teacherId;
    }
    public void setWorkId(String workId) 
    {
        this.workId = workId;
    }

    public String getWorkId() 
    {
        return workId;
    }
    public void setTeacherAccount(String teacherAccount) 
    {
        this.teacherAccount = teacherAccount;
    }

    public String getTeacherAccount() 
    {
        return teacherAccount;
    }
    public void setTeacherPassword(String teacherPassword)
    {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherPassword()
    {
        return teacherPassword;
    }
    public void setTeacherSex(String teacherSex) 
    {
        this.teacherSex = teacherSex;
    }

    public String getTeacherSex() 
    {
        return teacherSex;
    }
    public void setTeacherBirth(Date teacherBirth) 
    {
        this.teacherBirth = teacherBirth;
    }

    public Date getTeacherBirth() 
    {
        return teacherBirth;
    }
    public void setTeacherPhonenumber(Long teacherPhonenumber) 
    {
        this.teacherPhonenumber = teacherPhonenumber;
    }

    public Long getTeacherPhonenumber() 
    {
        return teacherPhonenumber;
    }
    public void setTeacherEmail(String teacherEmail) 
    {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherEmail() 
    {
        return teacherEmail;
    }
    public void setTeacherUnit(String teacherUnit) 
    {
        this.teacherUnit = teacherUnit;
    }

    public String getTeacherUnit() 
    {
        return teacherUnit;
    }
    public void setTeacherAcademy(String teacherAcademy) 
    {
        this.teacherAcademy = teacherAcademy;
    }

    public String getTeacherAcademy() 
    {
        return teacherAcademy;
    }
    public void setTeacherProfession(String teacherProfession) 
    {
        this.teacherProfession = teacherProfession;
    }

    public String getTeacherProfession() 
    {
        return teacherProfession;
    }
    public void setTeacherSign(String teacherSign) 
    {
        this.teacherSign = teacherSign;
    }

    public String getTeacherSign() 
    {
        return teacherSign;
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
            .append("teacherId", getTeacherId())
            .append("workId", getWorkId())
            .append("teacherAccount", getTeacherAccount())
            .append("teacherPassward", getTeacherPassword())
            .append("teacherSex", getTeacherSex())
            .append("teacherBirth", getTeacherBirth())
            .append("teacherPhonenumber", getTeacherPhonenumber())
            .append("teacherEmail", getTeacherEmail())
            .append("teacherUnit", getTeacherUnit())
            .append("teacherAcademy", getTeacherAcademy())
            .append("teacherProfession", getTeacherProfession())
            .append("teacherSign", getTeacherSign())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("deleted", getDeleted())
            .toString();
    }
}
