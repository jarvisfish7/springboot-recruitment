package com.gdpu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.VO.CompanyJobVO;
import com.gdpu.model.Job;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
public interface JobMapper extends BaseMapper<Job> {

    @Select("select a.*,b.name as companyName,b.stage as stage,b.kind as companyKind,b.place as companyPlace from job a inner join company b on a.companyid = b.company_id"
            + " ${ew.customSqlSegment}")
    IPage<CompanyJobVO> getJobandCompany(Page<CompanyJobVO> page, @Param(Constants.WRAPPER) QueryWrapper<CompanyJobVO> queryWrapper);
}
