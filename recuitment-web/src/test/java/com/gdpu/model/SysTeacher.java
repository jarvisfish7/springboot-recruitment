package com.gdpu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SysTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 老师编号
     */
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Long teacherId;

    /**
     * 老师姓名
     */
    private String teacherName;

    /**
     * 老师职位
     */
    private Long deptId;

    /**
     * 老师性别
     */
    private String teacherSex;

    /**
     * 老师手机
     */
    private Long teacherPhone;

    /**
     * 老师职位
     */
    private String teacherPosition;

    /**
     * 老师薪水
     */
    private Long teacherSalary;


}
