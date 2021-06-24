package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.mapper.CompanyMapper;
import com.gdpu.mapper.CompanyUserMapper;
import com.gdpu.model.Company;
import com.gdpu.model.CompanyUser;
import com.gdpu.model.User;
import com.gdpu.service.CompanyService;
import com.gdpu.util.RedisUtil;
import com.gdpu.util.ResultUtil;
import com.gdpu.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    ResultUtil resultUtil;

    @Autowired
    RedisUtil redisUtil;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Company company){
        System.out.println(company);
        int i = companyMapper.insert(company);
        if (i>=1){
            System.out.println("添加成功！");
            return resultUtil.customResult(200,"add success");
        }else {
            System.out.println("添加失败！");
            return resultUtil.customResult(400,"add failure");
        }
    }


}

