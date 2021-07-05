package com.gdpu.VO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class CompanyJobVO {
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
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


    /**
     * 是否有效,0有效
     */
    private Integer status;

    /**
     * 公司
     */
    private String companyName;

    /**
     * 公司领域
     */
    private String companyKind;

    /**
     * 融资
     */
    private String stage;
}
