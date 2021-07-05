package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gdpu.mapper.CollectionMapper;
import com.gdpu.mapper.JobMapper;
import com.gdpu.model.Collection;
import com.gdpu.model.Job;
import com.gdpu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author linjia
 * @since 2021-06-28
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    CollectionMapper collectionMapper;

    @Autowired
    JobMapper jobMapper;

    @Autowired
    ResultUtil resultUtil;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Collection collection) {
        if (collectionMapper.insert(collection)>0){
            return resultUtil.successResult();
        }else
            return resultUtil.failureResult();
    }

    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestBody Map<String,Integer> map){
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("job_id",map.get("jobId"));
        wrapper.eq("user_id",map.get("userId"));
        if (collectionMapper.delete(wrapper)>0){
            return resultUtil.successResult();
        }else {
            return resultUtil.failureResult();
        }
    }

    @PostMapping("/isExist")
    public Map<String, Object> isExist(@RequestBody Map<String,Integer> map){
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("job_id",map.get("jobId"));
        wrapper.eq("user_id",map.get("userId"));
        if (collectionMapper.selectCount(wrapper)>0){
            return resultUtil.successResult(true);
        }else {
            return resultUtil.successResult(false);
        }
    }

    /**
     * 通过user_id获取收藏的JobList
     */
    @GetMapping("/searchByuid/{id}")
    public Map<String, Object> searchByuid(@PathVariable("id") Integer userId){
        List<Integer> idList = collectionMapper.getJobIdList(userId);
        List<Job>  jobList = jobMapper.selectBatchIds(idList);
        return resultUtil.successResult(jobList);
    }


}

