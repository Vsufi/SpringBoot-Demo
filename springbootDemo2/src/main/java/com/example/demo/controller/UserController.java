package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sxx
 * @since 2020-02-13
 */
@RestController
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/test")
    public List<User> index(){
        return userService.list();
    }

    @ResponseBody
    @GetMapping("/page/{pageNo}")
    public Object testPage(@PathVariable int pageNo){
        IPage<User> page = new Page<>(pageNo,5);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        User user = new User();
//        user.setId(1);
//        wrapper.setEntity(user);
        return userService.page(page,wrapper);
    }

    @ResponseBody
    @GetMapping("/hello")
    public String sayHellotest(){
        return "hello,mybatis";
    }

    @ResponseBody
    @GetMapping("/queryid/{id}")
    public User queryByID(@PathVariable int  id){
        User byId = userService.getById(id);
        return byId;
    }

    @ResponseBody
    @GetMapping("/deleteid/{id}")
    public String deleteByID(@PathVariable int  id){
        userService.removeById(id);
        return "删除id为"+id+"的用户成功";
    }

    @ResponseBody
    @GetMapping("/update")
    public String update(){
        User user = new User();
        user.setId(1);
        user.setName("姚明");
        userService.updateById(user);
        return "更新成功";
    }
    @ResponseBody
    @GetMapping("/insert")
    public String insert(){
        User user = new User();
        user.setId(20);
        user.setName("新用户");
        userService.save(user);
        return "增加成功";
    }
}
