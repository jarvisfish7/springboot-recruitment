package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.VO.CompanyJobVO;
import com.gdpu.mapper.CompanyMapper;
import com.gdpu.model.Company;
import com.gdpu.service.CompanyService;
import com.gdpu.util.FileUtil;
import com.gdpu.util.RedisUtil;
import com.gdpu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
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

    @Autowired
    FileUtil fileUtil;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Company company) {
        System.out.println(company);
        int i = companyMapper.insert(company);
        if (i >= 1) {
            System.out.println("添加成功！");
            return resultUtil.customResult(200, "add success");
        } else {
            System.out.println("添加失败！");
            return resultUtil.customResult(400, "add failure");
        }
    }

    @GetMapping("/getByid/{id}")
    public Map<String, Object> getByid(@PathVariable("id") Integer id) {
        System.out.println("进来了");
        Company company = companyMapper.selectById(id);
        System.out.println("查找成功！");
        return resultUtil.customResult(200, "查找成功", company);
    }

    @PostMapping("/uploadImg")
    public Map<String, Object> uploadImg(@RequestParam("avatar") MultipartFile image,
                                         @RequestParam("companyid") Integer id) {
        String url = fileUtil.uploadImage(image);

        //删除旧的
        String oldimg = companyMapper.selectById(id).getAvatar();
        fileUtil.deleteImage(oldimg);

        //改数据库url
        UpdateWrapper<Company> update = new UpdateWrapper<>();
        update.eq("company_id", id).set("avatar", url);
        int i = companyMapper.update(null, update);
        if (i > 0) {
            return resultUtil.urlResult(200, "上传成功",url);
        }
        return resultUtil.customResult(400, "add failure");
    }

    /**
     * 条件搜索加分页
     */
    @RequestMapping("/search")
    public Map<String, Object> search (@RequestBody Map<String,Object> map){

        Map<String,String> condition = (Map<String, String>) map.get("condition");

        Integer currentPage = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");
        String  keyword = (String) map.get("keyword");
        Page<Company> page = new Page<>(currentPage,pageSize);
        IPage<Company> iPage = companyService.PageSearch(page,condition,keyword);

        return resultUtil.successResult(iPage);
    }



}

