package com.gdpu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.gdpu.VO.JobDeliverResume;
import com.gdpu.model.Deliver;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author linjia
 * @since 2021-06-28
 */
public interface DeliverMapper extends BaseMapper<Deliver> {

    @Select("SELECT `job_id` FROM `deliver`  WHERE `apply_id` =  #{userId}")
    List<Integer> getJobIdList(Integer userId);

    //    获取不合适
    @Select("SELECT `job_id` FROM `deliver`  WHERE `apply_id` = #{userId} and `status` IN (2,6)")
    List<Integer> getJobIdUns(Integer userId);

    //    获取邀请面试的
    @Select("SELECT `job_id` FROM `deliver`  WHERE `apply_id` = #{userId} and `status` IN (1,4)")
    List<Integer> getJobIdFac(Integer userId);

    @Select("select a.id as deliverId,a.create_time as postTime ,a.`status`,b.job_id AS jobId,b.job_name AS jobName,c.* from deliver a inner join job b on a.job_id = b.job_id left join resume c on c.user_id = a.apply_id"
            + " ${ew.customSqlSegment}")
    List<JobDeliverResume> getDeliver(@Param(Constants.WRAPPER) QueryWrapper<JobDeliverResume> queryWrapper);

    @Update("update `deliver` set status = #{status} WHERE `id` =  #{id}")
    Integer setStatus(Integer id, Integer status);
}
