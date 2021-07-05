package com.gdpu.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Component
public class JobDeliverResume {

    private Integer deliverId;

    private Integer jobId;

    private String jobName;

    private Integer resumeId;
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 名字
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private String birth;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 工作经历
     */
    private String experience;

    /**
     * 期望工作
     */
    private String desiredjob;

    /**
     * 期望薪资
     */
    private BigDecimal desiredsalary;

    /**
     * 期望城市
     */
    private String desiredcity;

    private String school;

    private String subject;

    private String academic;

    private String begindate;

    private String enddate;

    private String projectname;

    private String duty;

    private Date starttime;

    private Date endtime;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 自我评价
     */
    private String assessment;

    /**
     * 图片地址
     */
    private String avatar;

    /**
     * 投递时间
     */
    private Date postTime;
}
