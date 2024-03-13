package org.pguide.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName usercenter_teacher_info
 */
@TableName(value ="usercenter_teacher_info")
@Data
public class UsercenterTeacherInfo implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer teacherId;

    /**
     * 用户名
     */
    private String teacherName;

    /**
     * 昵称
     */
    private String teacherNick;

    /**
     * 工号
     */
    private String workId;

    /**
     * 用户账户
     */
    private String teacherAccount;

    /**
     * 老师密码
     */
    private String teacherPassword;

    /**
     * 用户性别
     */
    private String teacherSex;

    /**
     * 用户生日
     */
    private LocalDate teacherBirth;

    /**
     * 用户手机号
     */
    private Integer teacherPhonenumber;

    /**
     * 用户邮箱号
     */
    private String teacherEmail;

    /**
     * 用户单位
     */
    private String teacherUnit;

    /**
     * 
     */
    private String teacherAcademy;

    /**
     * 用户专业
     */
    private String teacherProfession;

    /**
     * 用户个人签名
     */
    private String teacherSign;

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 更新时间
     */
    private LocalDateTime updated;

    /**
     * 逻辑删除 0删除状态 1没有删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}