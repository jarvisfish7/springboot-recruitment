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
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "company_id", type = IdType.AUTO)
    private Integer companyId;

    private Integer userId;

    private String name;

    /**
     * 公司领域
     */
    private String kind;

    /**
     * 公司所在城市
     */
    private String place;

    /**
     * 融资
     */
    private String stage;

    /**
     * 规模
     */
    private String scale;

    /**
     * 公司网址
     */
    private String url;

    /**
     * 公司描述
     */
    private String comintroduce;

    /**
     * 公司具体地址
     */
    private String address;

    /**
     * 图片地址
     */
    private String avatar;


}
