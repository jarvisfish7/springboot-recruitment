package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.mapper.FaceMapper;
import com.gdpu.model.Collection;
import com.gdpu.model.Face;
import com.gdpu.util.ResultUtil;
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
 * @since 2021-06-28
 */
@RestController
@RequestMapping("/face")
public class FaceController {
    @Autowired
    FaceMapper faceMapper;
    @Autowired
    ResultUtil resultUtil;
    /**
     * 面试添加
     */
    @PostMapping("/add")
    public Map<String, Object> add (@RequestBody Face face){
        if (faceMapper.insert(face)>0){
            return resultUtil.successResult();
        }else {
            return resultUtil.failureResult();
        }
    }

    @PostMapping("/isExist")
    public Map<String, Object> isExist(@RequestBody Map<String,Integer> map){
        QueryWrapper<Face> wrapper = new QueryWrapper<>();
        wrapper.eq("apply_id",map.get("applyId"));
        wrapper.eq("company_id",map.get("companyId"));
        if (faceMapper.selectCount(wrapper)>0){
            return resultUtil.successResult(true);
        }else {
            return resultUtil.successResult(false);
        }
    }

    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestBody Map<String,Integer> map){
        QueryWrapper<Face> wrapper = new QueryWrapper<>();
        wrapper.eq("apply_id",map.get("applyId"));
        wrapper.eq("company_id",map.get("companyId"));
        if (faceMapper.delete(wrapper)>0){
            return resultUtil.successResult();
        }else {
            return resultUtil.failureResult();
        }
    }
}

