package com.gdpu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
public class SecondType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 第二类的id
     */
    @TableId(value = "second_id", type = IdType.AUTO)
    private Integer secondId;

    /**
     * 第二类名字
     */
    private String secondName;

    /**
     * 第一类id
     */
    private Integer firstId;

    /**
     * 是否删除，0,1
     */
    @TableLogic
    private Integer deleted;


}
