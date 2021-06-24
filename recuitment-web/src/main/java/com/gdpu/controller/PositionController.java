package com.gdpu.controller;


import com.gdpu.mapper.FirstTypeMapper;
import com.gdpu.mapper.PositionMapper;
import com.gdpu.mapper.SecondTypeMapper;
import com.gdpu.model.FirstType;
import com.gdpu.model.Position;
import com.gdpu.model.SecondType;
import com.gdpu.service.FirstTypeService;
import com.gdpu.service.PositionService;
import com.gdpu.service.SecondTypeService;
import com.gdpu.util.ItemTreeRoot;
import com.gdpu.util.ItemTreeUtil;
import com.gdpu.util.RedisUtil;
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
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private FirstTypeService firstTypeService;
    @Autowired
    private SecondTypeService secondTypeService;
    @Autowired
    private PositionService positionService;

    @Autowired
    private ResultUtil resultUtil;

    @Autowired
    private RedisUtil redisUtil;


    /*
    初始化级联的数据
     */
    @GetMapping("/allData")
    public Map<String, Object> positionData (){
        if(redisUtil.hasKey("PositionCascader")){
            System.out.println("redis输出的数据");
            return resultUtil.customResult(200,"success",redisUtil.get("PositionCascader"));
        }else{
            List<FirstType> firstTypeList = firstTypeService.selectAll();
            List<SecondType> secondTypeList = secondTypeService.selectAll();
            List<Position> positionList = positionService.selectAll();
            Map<Integer, List<ItemTreeRoot>> PMap = ItemTreeUtil.ItemP(positionList);
            Map<Integer, List<ItemTreeRoot>> SMap = ItemTreeUtil.ItemS(PMap,secondTypeList);
            List<ItemTreeRoot> alllist = ItemTreeUtil.ItemF(SMap,firstTypeList);
            redisUtil.set("PositionCascader",alllist,300);
            return resultUtil.customResult(200,"success",alllist);
        }

    }

    @PostMapping("/add")
    public void positionAdd(@RequestBody Map<String,String> data){
        System.out.println(data);

    }


}

