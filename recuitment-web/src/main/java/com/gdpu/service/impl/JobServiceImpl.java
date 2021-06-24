package com.gdpu.service.impl;

import com.gdpu.model.Job;
import com.gdpu.mapper.JobMapper;
import com.gdpu.service.JobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

}
