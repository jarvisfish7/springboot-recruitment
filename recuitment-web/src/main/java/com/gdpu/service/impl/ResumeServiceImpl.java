package com.gdpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.model.Resume;
import com.gdpu.model.Resume;
import com.gdpu.mapper.ResumeMapper;
import com.gdpu.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    @Autowired
    StringUtil stringUtil;
    @Override
    public Resume selectByUid(Integer uid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",uid);
        return resumeMapper.selectOne(wrapper);
    }

    @Override
    public IPage<Resume> PageSearch(Page<Resume> page, Map<String, String> condition, String keyword) {
        QueryWrapper<Resume> wrapper = new QueryWrapper<>();
        wrapper.like("name",keyword);
        String value;
        for (String key : condition.keySet()) {
            value = condition.get(key);
            if (stringUtil.isNotEmpty(value)){
                if (!(value.equals("全国")) && !(value.equals("不限")))
                    wrapper.eq(key,condition.get(key));
            }
        }
        IPage<Resume> iPage = resumeMapper.selectPage(page,wrapper);
        return iPage;
    }
}
