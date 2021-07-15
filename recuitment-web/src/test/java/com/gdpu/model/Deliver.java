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
public class Deliver implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer applyId;

    private Integer companyId;

    private Integer jobId;

    private Integer resumeId;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
