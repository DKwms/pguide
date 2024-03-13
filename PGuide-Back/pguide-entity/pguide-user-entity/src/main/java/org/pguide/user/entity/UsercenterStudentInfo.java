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
 * @TableName usercenter_student_info
 */
@TableName(value ="usercenter_student_info")
@Data
public class UsercenterStudentInfo implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer studentId;


    /**
     * 用户名
     */
    private String studentName;

    /**
     * 昵称
     */
    private String studentNick;

    /**
     * 
     */
    private String studentAccount;

    /**
     * 
     */
    private String studentPassword;

    /**
     * 学号
     */
    private String workId;

    /**
     * 用户性别
     */
    private String studentSex;

    /**
     * 用户生日
     */
    private LocalDate studentBirth;

    /**
     * 用户手机号
     */
    private Integer studentPhonenumber;

    /**
     * 用户邮箱号
     */
    private String studentEmail;

    /**
     * 用户学校
     */
    private String studentSchool;

    /**
     * 用户学院
     */
    private String studentAcademy;

    /**
     * 用户年级
     */
    private String studentYear;

    /**
     * 用户专业
     */
    private String studentProfession;

    /**
     * 用户个人签名
     */
    private String userSign;

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