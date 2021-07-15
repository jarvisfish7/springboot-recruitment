package com.gdpu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author linjia
 * @since 2021-07-15
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
     * 是否有效,0有效
     */
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
