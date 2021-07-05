package com.gdpu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class Face implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer id;

    private Integer applyId;

    private Integer companyId;

    private Integer jobId;

    private Integer status;


}
