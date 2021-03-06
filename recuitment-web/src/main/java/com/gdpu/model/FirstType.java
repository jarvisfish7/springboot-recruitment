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
public class FirstType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 第一类id
     */
    @TableId(value = "first_id", type = IdType.AUTO)
    private Integer firstId;

    /**
     * 第一类名称
     */
    private String firstName;


}
