package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/query")
    public Map<String ,Object> map(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * FROM user");
        return list.get(0);
    }
    @ResponseBody
    @GetMapping("/update")
    public String update(){
        jdbcTemplate.update("update user set name='李明' where id = 1");
        return "更新成功";
    }
    @ResponseBody
    @GetMapping("/delete")
    public String delete(){
        jdbcTemplate.update("delete  from user where id = 1");
        return "删除成功";
    }
    @ResponseBody
    @GetMapping("/insert")
    public String insert(){
        jdbcTemplate.update("insert into user(id,name,password,address,phone) value ('20','小明','qwerty','Shanghai','13677799222')");
        return "插入成功";
    }
}
