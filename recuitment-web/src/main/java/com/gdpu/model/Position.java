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
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职位id
     */
    @TableId(value = "position_id", type = IdType.AUTO)
    private Integer positionId;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 描述
     */
    private String positionDescribe;

    private Integer secondTypeId;


}
