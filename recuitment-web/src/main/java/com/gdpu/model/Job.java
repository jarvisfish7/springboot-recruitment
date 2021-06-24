package com.gdpu.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
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

    /**
     * id
     */
    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer jobId;

    /**
     * 发布者的用户id
     */
    private Integer cuserId;

    /**
     * 工作名称
     */
    private String jobName;

    /**
     * 一类id
     */
    private Integer firstTypeId;

    /**
     * 二类id
     */
    private Integer secondTypeId;

    /**
     * 发布的公司id
     */
    private Integer jobCompanyId;

    /**
     * 工作职位
     */
    private Integer jobPosition;

    /**
     * 需要技术
     */
    private String requireTech;

    /**
     * 工作位置
     */
    private String jobLocation;

    /**
     * 工作薪资
     */
    private String jobSalary;

    /**
     * 工作学历要求
     */
    private String jobEducation;

    /**
     * 电话
     */
    private String jobPhone;

    /**
     * 联系邮箱
     */
    private String jobEmail;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 默认0,删除是1
     */
    @TableLogic
    private Integer deleted;


}
