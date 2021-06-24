package com.gdpu.service;

import com.gdpu.model.FirstType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
public interface FirstTypeService extends IService<FirstType> {
    /*
    获取全部的集合
     */
    List<FirstType> selectAll();

    /*
    通过id查找
     */
    FirstType selectById(Integer id);



}
