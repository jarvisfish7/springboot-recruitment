package com.gdpu.controller;


import com.gdpu.mapper.FirstTypeMapper;
import com.gdpu.mapper.UserMapper;
import com.gdpu.model.FirstType;
import com.gdpu.service.FirstTypeService;
import com.gdpu.service.UserService;
import com.gdpu.util.ResultUtil;
import com.gdpu.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
@RequestMapping("/first-type")
public class FirstTypeController {
    @Autowired
    private FirstTypeService firsttypeService;

    @Autowired
    private FirstTypeMapper firsttypeMapper;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    ResultUtil resultUtil;

    @GetMapping("/all")
    public Map<String, Object> getAll(){
        List<FirstType> list = firsttypeMapper.selectList(null);
        return resultUtil.customResult(200,"success",list);
    }


}

