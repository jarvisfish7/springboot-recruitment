package com.gdpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.VO.CompanyJobVO;
import com.gdpu.mapper.JobMapper;
import com.gdpu.model.Job;
import com.gdpu.service.JobService;
import com.gdpu.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
    @Autowired
    JobMapper jobMapper;
    @Autowired
    StringUtil stringUtil;

    @Override
    public IPage<CompanyJobVO> PageSearch(Map<String, String> condition, Integer currentPage, Integer pageSize, String keyword) {
        QueryWrapper<CompanyJobVO> wrapper = new QueryWrapper<>();
        if (keyword != null) {
            wrapper.like("job_name", keyword);
        }
        wrapper.eq("`status`", 0);
        String value;
        for (String key : condition.keySet()) {
            value = condition.get(key);
            if (stringUtil.isNotEmpty(value)) {
                if (!(value.equals("全国市")) && !(value.equals("不限")))
                    wrapper.eq(key, condition.get(key));
            }
        }
        Page<CompanyJobVO> page = new Page<>(currentPage, pageSize);
        IPage<CompanyJobVO> iPage = jobMapper.getJobandCompany(page, wrapper);
//        page.setRecords(jobMapper.getJobandCompany(page,wrapper));
        return iPage;
    }
}
