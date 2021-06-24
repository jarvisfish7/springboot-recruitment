package com.gdpu.service;

import com.gdpu.model.Position;
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
public interface PositionService extends IService<Position> {
    /*
    获取全部的集合
     */
    List<Position> selectAll();

    /*
    通过id查找
     */
    Position selectById(Integer id);

    /*

     */
}
