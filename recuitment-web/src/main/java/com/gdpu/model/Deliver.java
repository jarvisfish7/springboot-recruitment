package com.gdpu.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Deliver implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer applyId;

    private Integer companyId;

    private Integer jobId;

    private Integer resumeId;

    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

}
