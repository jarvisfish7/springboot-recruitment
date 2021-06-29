package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.mapper.ResumeMapper;
import com.gdpu.mapper.UserMapper;
import com.gdpu.model.Resume;
import com.gdpu.model.User;
import com.gdpu.service.UserService;
import com.gdpu.util.RedisUtil;
import com.gdpu.util.ResultUtil;
import com.gdpu.util.TokenUtil;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    ResultUtil resultUtil;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ResumeMapper resumeMapper;

    @GetMapping("/list")
    public List<User> list() {
//        System.out.println(this.userService.selectList(null));
        return this.userService.list(null);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") Integer id) {
        return this.userMapper.deleteById(id);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
//        System.out.println(data.get("username"));
//        System.out.println(data.get("password"));
        String name = data.get("username");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("`username`", data.get("username"));
        wrapper.eq("`password`", data.get("password"));
        if (userMapper.selectCount(wrapper) >= 1) {
            User user = userMapper.selectOne(wrapper);
            Integer userid = user.getId();
            String token = tokenUtil.generateToken(data.get("username"));
            System.out.println("登录成功！");
            return resultUtil.customResult(200, "login success", token, name, userid);
        } else {
            System.out.println("登录失败！");
            return resultUtil.customResult(503, "login failure");
        }
    }

    @PostMapping("/regist")
    public Map<String, Object> regist(@RequestBody Map<String, String> data) {
        User user = new User();
        user.setUsername(data.get("user"));
        user.setPassword(data.get("pass"));
        //条件构造
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("`username`", data.get("user"));
        wrapper.eq("`password`", data.get("pass"));

        if (userMapper.insert(user) > 0) {
            User user1 = userMapper.selectOne(wrapper);
            String username = user1.getUsername();
            Integer userid = user1.getId();
            System.out.println("注册成功！");
            return resultUtil.userResult(200, "regist success", user1);
        } else {
            System.out.println("注册失败！");
            return resultUtil.customResult(400, "regist failure");
        }
    }

    @PostMapping("/isExist")
    public Map<String, Object> isExist(@RequestBody Map<String, String> data) {
        System.out.println("isExist");
        String username = data.get("user");
        QueryWrapper<User> condition = new QueryWrapper<>();
        condition.eq("`username`", username);
        if (userMapper.selectCount(condition) >= 1) {
            System.out.println("注册名已存在！");
            return resultUtil.customResult(400, "用户名已存在");
        } else {
            return resultUtil.customResult(200, "用户还没存在");
        }
    }

    /**
     * 通过id获取全部信息
     */
    @GetMapping("/getByid/{id}")
    public Map<String, Object> getByid (@PathVariable Integer id){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        Resume resume = resumeMapper.selectOne(wrapper);
        return resultUtil.customResult(200,"用户查找成功",resume);
    }
}

