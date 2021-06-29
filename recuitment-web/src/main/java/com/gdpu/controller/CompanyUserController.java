package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.mapper.CompanyUserMapper;
import com.gdpu.model.CompanyUser;
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
 *  前端控制器
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/company-user")
public class CompanyUserController {

    @Autowired
    CompanyUserMapper companyUserMapper;

    @Autowired
    CompanyService companyService;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    ResultUtil resultUtil;

    @Autowired
    RedisUtil redisUtil;


    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String,String> data){
//        System.out.println(data.get("username"));
//        System.out.println(data.get("password"));
        String name = data.get("username");
        QueryWrapper<CompanyUser> wrapper = new QueryWrapper<>();
        wrapper.eq("`username`",data.get("username"));
        wrapper.eq("`password`",data.get("password"));
        System.out.println(companyUserMapper.selectCount(wrapper));
        if (companyUserMapper.selectCount(wrapper)>=1){
            CompanyUser user = companyUserMapper.selectOne(wrapper);
            Integer userid = user.getId();
            Integer companyid =  companyService.selectByuid(userid).getCompanyId();
            String token = tokenUtil.generateToken(data.get("username"));
            System.out.println("登录成功！");
            return resultUtil.customResult(200,"login success",token,name,userid,companyid);
        }else {
            System.out.println("登录失败！");
            return resultUtil.customResult(503,"login failure");
        }
    }

    @PostMapping("/regist")
    public Map<String, Object> regist(@RequestBody Map<String,String> data){
        CompanyUser companyUser = new CompanyUser();
        companyUser.setUsername(data.get("user"));
        companyUser.setPassword(data.get("pass"));
        //查询条件
        QueryWrapper<CompanyUser> wrapper = new QueryWrapper<>();
        wrapper.eq("`username`",data.get("user"));
        wrapper.eq("`password`",data.get("pass"));

        if (companyUserMapper.insert(companyUser)>0){
            CompanyUser user = companyUserMapper.selectOne(wrapper);
            String username = user.getUsername();
            Integer userid = user.getId();
            System.out.println("注册成功！");
            return resultUtil.userResult(200,"regist success",user);
        }else {
            System.out.println("注册失败！");
            return resultUtil.customResult(400,"regist failure");
        }
    }

    @PostMapping("/isExist")
    public Map<String, Object> isExist(@RequestBody Map<String,String> data){
        String username = data.get("user");
        QueryWrapper<CompanyUser> condition = new QueryWrapper<>();
        condition.eq("`username`",username);
        if (companyUserMapper.selectCount(condition)>=1){
            return resultUtil.customResult(400,"用户名已存在");
        }else {
            return resultUtil.customResult(200,"用户还没存在");
        }
    }
}

