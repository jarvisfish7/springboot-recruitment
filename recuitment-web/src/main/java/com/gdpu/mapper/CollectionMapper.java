package com.gdpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdpu.model.Collection;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author linjia
 * @since 2021-06-28
 */
public interface CollectionMapper extends BaseMapper<Collection> {

    @Select("SELECT `job_id` FROM `collection`  WHERE `user_id` =  #{userId}")
    List<Integer> getJobIdList(Integer userId);
}
