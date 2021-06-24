package com.gdpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.model.Company;
import com.gdpu.mapper.CompanyMapper;
import com.gdpu.model.CompanyUser;
import com.gdpu.service.CompanyService;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public Company selectByuid(Integer uid) {
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.eq("`company_uid`",uid);
        return companyMapper.selectOne(wrapper);
    }
}
