package com.gdpu.controller;


import com.gdpu.mapper.ResumeMapper;
import com.gdpu.model.Resume;
import com.gdpu.util.RedisUtil;
import com.gdpu.util.ResultUtil;
import com.gdpu.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    ResumeMapper resumeMapper;
    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    ResultUtil resultUtil;

    @Autowired
    RedisUtil redisUtil;
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Resume resume){
        System.out.println(resume);
        int i = resumeMapper.insert(resume);
        if (i>=1){
            System.out.println("添加成功！");
            return resultUtil.customResult(200,"add success");
        }else {
            System.out.println("添加失败！");
            return resultUtil.customResult(400,"add failure");
        }
    }
    @GetMapping("/test")
    public Resume test(){
        return resumeMapper.selectById(1);
    }

}

