package com.gdpu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdpu.VO.CompanyJobVO;
import com.gdpu.model.Job;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
public interface JobService extends IService<Job> {

    /**
     * 分页搜索search
     * @return
     */
    IPage<CompanyJobVO> PageSearch(Map<String,String> condition, Integer currentPage, Integer pageSize, String  keyword);

}
