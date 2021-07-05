package com.gdpu.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author linjia
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer jobId;

    private Integer userId;

    /**
     * 公司的id
     */
    private Integer companyid;

    /**
     * 工作名称
     */
    private String jobName;

    /**
     * 职位类别
     */
    private String kind;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 薪资
     */
    private String salary;

    /**
     * 工作城市
     */
    private String place;

    private String experience;

    private String academic;

    private String address;

    private String jobdescription;

    private String jobneed;

    /**
     * 接收的邮箱
     */
    private String remail;

    private String hr;


    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    /**
     * 是否有效,0有效
     */
    private Integer status;



}
