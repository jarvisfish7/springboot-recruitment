package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.VO.JobDeliverResume;
import com.gdpu.mapper.DeliverMapper;
import com.gdpu.mapper.JobMapper;
import com.gdpu.mapper.ResumeMapper;
import com.gdpu.model.Resume;
import com.gdpu.model.Deliver;
import com.gdpu.model.Job;
import com.gdpu.model.Resume;
import com.gdpu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linjia
 * @since 2021-06-28
 */
@RestController
@RequestMapping("/deliver")
public class DeliverController {


    @Autowired
    DeliverMapper deliverMapper;

    @Autowired
    JobMapper jobMapper;

    @Autowired
    ResultUtil resultUtil;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Deliver deliver){
       if (deliverMapper.insert(deliver)>0){
           return resultUtil.successResult();
       }else
           return resultUtil.failureResult();
    }

    /**
     * 查一个人的所有投递，返回一个List<Job>
     */
    @GetMapping("/searchByuid/{id}")
    public Map<String, Object> searchByuid(@PathVariable("id") Integer userId){
        List<Integer> idList = deliverMapper.getJobIdList(userId);
        List<Job>  jobList = jobMapper.selectBatchIds(idList);
        return resultUtil.successResult(jobList);
    }


    /**
     * 查不合适的JobList
     */
    @GetMapping("/searchunsByuid/{id}")
    public Map<String, Object> searchunsByuid(@PathVariable("id") Integer userId){
        List<Integer> idList = deliverMapper.getJobIdUns(userId);
        List<Job>  jobList = jobMapper.selectBatchIds(idList);
        return resultUtil.successResult(jobList);
    }


    /**
     * 查合适的面试的JobList
     */
    @GetMapping("/searchfacByuid/{id}")
    public Map<String, Object> searchfacByuid(@PathVariable("id") Integer userId){
        List<Integer> idList = deliverMapper.getJobIdUns(userId);
        List<Job>  jobList = jobMapper.selectBatchIds(idList);
        return resultUtil.successResult(jobList);
    }

    /**
     * 查看投递简历，各状态
     */
    @PostMapping("/getBycid")
    public Map<String, Object> getBycid (@RequestBody Map<String,Integer> map){
        Integer status = map.get("status");
        Integer companyId = map.get("companyId");
        QueryWrapper<JobDeliverResume> wrapper = new QueryWrapper<>();
        wrapper.eq("a.status",status);
        wrapper.eq("a.company_id",companyId);
        List<JobDeliverResume> list = deliverMapper.getDeliver(wrapper);
        return resultUtil.successResult(list);
    }

    /**
     * 标记status，0未处理，1，已处理，2，不合适
     */
    @PostMapping("/setStatus")
    public Map<String, Object> setStatus (@RequestBody Map<String,Integer> map){
        Integer id = map.get("id");
        Integer status = map.get("status");
        if (deliverMapper.setStatus(id,status)>0){
            return resultUtil.successResult();
        }else {
            return resultUtil.failureResult();
        }
    }

    /***
     * 是否存在
     */
    @PostMapping("/isExist")
    public Map<String, Object> isExist(@RequestBody Map<String,Integer> map){
        QueryWrapper<Deliver> wrapper = new QueryWrapper<>();
        wrapper.eq("apply_id",map.get("applyId"));
        wrapper.eq("job_id",map.get("jobId"));
        if (deliverMapper.selectCount(wrapper)>0){
            return resultUtil.successResult(true);
        }else {
            return resultUtil.successResult(false);
        }
    }


}

