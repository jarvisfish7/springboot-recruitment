package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.mapper.ResumeMapper;
import com.gdpu.model.Resume;
import com.gdpu.model.Resume;
import com.gdpu.model.Resume;
import com.gdpu.service.ResumeService;
import com.gdpu.util.FileUtil;
import com.gdpu.util.RedisUtil;
import com.gdpu.util.ResultUtil;
import com.gdpu.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    ResumeService resumeService;
    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    FileUtil fileUtil;

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

    @GetMapping("/getByuid/{id}")
    public Map<String, Object> getByuid(@PathVariable Integer id){
        QueryWrapper<Resume> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        Resume resume = resumeMapper.selectOne(wrapper);
        return resultUtil.customResult(200,"获取成功！",resume);
    }

    /**
     * 条件搜索加分页
     */
    @PostMapping("/search")
    public Map<String, Object> search (@RequestBody Map<String,Object> map){
        Map<String,String> condition = (Map<String, String>) map.get("condition");
        Integer currentPage = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");
        String  keyword = (String) map.get("keyword");
        Page<Resume> page = new Page<>(currentPage,pageSize);
        IPage<Resume> iPage = resumeService.PageSearch(page,condition,keyword);
        return resultUtil.successResult(iPage);
    }


    @PostMapping("/uploadImg")
    public Map<String, Object> uploadImg(@RequestParam("avatar") MultipartFile image,
                                         @RequestParam("resumeId") Integer id) {
        String url = fileUtil.uploadImage(image);

        //删除旧的
        String oldimg = resumeMapper.selectById(id).getAvatar();
        fileUtil.deleteImage(oldimg);

        //改数据库url
        UpdateWrapper<Resume> update = new UpdateWrapper<>();
        update.eq("resume_id", id).set("avatar", url);
        int i = resumeMapper.update(null, update);
        if (i > 0) {
            return resultUtil.urlResult(200, "上传成功", url);
        }
        return resultUtil.customResult(400, "add failure");
    }
}

