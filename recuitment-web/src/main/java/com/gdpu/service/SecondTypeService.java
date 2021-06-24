package com.gdpu.service;


import com.gdpu.model.SecondType;
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
public interface SecondTypeService extends IService<SecondType> {
    /*
    获取全部的集合
     */
    List<SecondType> selectAll();

    /*
    通过id查找
     */
    SecondType selectById(Integer id);

    /*
    通过一类id查找
     */
    List<SecondType> selectByFId(Integer fid);
}
