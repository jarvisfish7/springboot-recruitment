package com.gdpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.model.Resume;
import com.gdpu.mapper.ResumeMapper;
import com.gdpu.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements ResumeService {
    @Autowired
    ResumeMapper resumeMapper;
    @Override
    public Resume selectByUid(Integer uid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",uid);
        return resumeMapper.selectOne(wrapper);
    }
}
