package com.gdpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.model.Company;
import com.gdpu.mapper.CompanyMapper;
import com.gdpu.service.CompanyService;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    StringUtil stringUtil;

    @Override
    public Company selectByuid(Integer uid) {
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.eq("`user_id`",uid);
        return companyMapper.selectOne(wrapper);
    }

    @Override
    public IPage<Company> PageSearch(Page<Company> page, Map<String, String> condition, String keyword) {
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.like("name",keyword);
        String value;
        for (String key : condition.keySet()) {
            value = condition.get(key);
            if (stringUtil.isNotEmpty(value)){
                if (!(value.equals("全国市")) && !(value.equals("不限")))
                    wrapper.eq(key,condition.get(key));
            }
        }
        IPage<Company> iPage = companyMapper.selectPage(page,wrapper);
        return iPage;
    }
}
