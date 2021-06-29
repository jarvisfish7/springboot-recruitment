package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.VO.CompanyJobVO;
import com.gdpu.mapper.JobMapper;
import com.gdpu.model.Company;
import com.gdpu.model.Job;
import com.gdpu.service.JobService;
import com.gdpu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobMapper jobMapper;

    @Autowired
    ResultUtil resultUtil;

    @Autowired
    JobService jobService;

    @PostMapping("/add")
    public Map<String, Object> JobAdd(@RequestBody Job job) {
////        for(String key:data.keySet()){
////            System.out.println("key:"+key+" "+"Value:"+data.get(key));
////        }
//        Job job = jobDataUtil.toJob(data);
//        int i = jobMapper.insert(job);
//        if (i>0){
//            System.out.println("插入了！");
//        }
        System.out.println(job);
        int i = jobMapper.insert(job);
        String message = "insert success!";
        if (i > 0) {
            System.out.println("插入了！");
            return resultUtil.successResult(message);
        } else {
            return resultUtil.customResult(503, "insert failure");
        }
    }

    /**
     * 查有效的发布的工作
     *
     * @param companyid
     * @return
     */
    @GetMapping("/selectListBycid/{companyid}")
    public Map<String, Object> selectListBycid(@PathVariable("companyid") Integer companyid) {
        QueryWrapper<Job> wrapper = new QueryWrapper<Job>();
        wrapper.eq("companyid", companyid);
        //设置为0
        wrapper.eq("`status`", 0);
        List<Job> list = jobMapper.selectList(wrapper);
        System.out.println("输出了！");
        return resultUtil.customResult(200, "success", list);
    }

    /**
     * 查无效的
     *
     * @param
     * @return
     */

    @GetMapping("/selectNOListBycid/{companyid}")
    public Map<String, Object> selectNOListBycid(@PathVariable("companyid") Integer companyid) {
        QueryWrapper<Job> wrapper = new QueryWrapper<Job>();
        wrapper.eq("companyid", companyid);
        //设置为0
        wrapper.eq("`status`", 1);
        List<Job> list = jobMapper.selectList(wrapper);
        System.out.println("输出了！");
        return resultUtil.customResult(200, "success", list);
    }

    /**
     * 下线
     *
     * @param data
     * @return
     */
    @PostMapping("/deleteByid")
    public Map<String, Object> deleteByid(@RequestBody Map<String, String> data) {
        Integer id = Integer.valueOf(data.get("jobId"));
        UpdateWrapper<Job> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("`job_id`", id).set("status", 1);
        if (jobMapper.update(null, updateWrapper) >= 1) {
            return resultUtil.successResult("success!");
        } else
            return resultUtil.customResult(500, "down failure");
    }

    /**
     * 编辑删除
     *
     * @param job
     * @return
     */

    @PostMapping("/edit")
    public Map<String, Object> edit(@RequestBody Job job) {
        if (jobMapper.updateById(job) >= 1) {
            return resultUtil.successResult("成功编辑");
        } else {
            return resultUtil.customResult(500, "update failure");
        }
    }

    /**
     * 物理删除
     */
    @GetMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        if (jobMapper.deleteById(id) >= 1) {
            return resultUtil.successResult("成功删除");
        } else {
            return resultUtil.customResult(500, "delete failure");
        }
    }
//

    /**
     * 分页查询
     * 查找joblist
     */
    @PostMapping("/search")
    public Map<String, Object> search( @RequestBody Map<String,Object> map) {

        Map<String,String> condition = (Map<String, String>) map.get("condition");

        //a和b表的place重名
        String value = condition.get("place");
        condition.put("a.place",value);
        condition.remove("place");

        Integer currentPage = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");
        String  keyword = (String) map.get("keyword");
        IPage<CompanyJobVO> page= jobService.PageSearch(condition,currentPage,pageSize,keyword);

        return resultUtil.customResult(200,"success",page);
    }

    /**
     * 通过id找Job对象
     */
    @GetMapping("/getByid/{id}")
    public Map<String, Object> getByid(@PathVariable Integer id){
        Job job = jobMapper.selectById(id);
        return resultUtil.successResult("success",job);
    }
}

