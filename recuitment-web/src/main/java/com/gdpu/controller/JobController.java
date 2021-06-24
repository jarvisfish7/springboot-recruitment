package com.gdpu.controller;


import com.gdpu.mapper.JobMapper;
import com.gdpu.model.Job;
import com.gdpu.util.JobDataUtil;
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
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobDataUtil jobDataUtil;

    @Autowired
    JobMapper jobMapper;

    @PostMapping("/add")
    public void JobAdd(@RequestBody Map<String,String> data){
//        for(String key:data.keySet()){
//            System.out.println("key:"+key+" "+"Value:"+data.get(key));
//        }
        Job job = jobDataUtil.toJob(data);
        int i = jobMapper.insert(job);
        if (i>0){
            System.out.println("插入了！");
        }
    }
}

