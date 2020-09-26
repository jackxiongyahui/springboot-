package com.westone.springbootfirstdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author A
 */
@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello(){
        return "hello srping boot";
    }

//    @RequestMapping({"/","/login.html"})
//    public String login(){
//        return "login";
//    }

    //查出一些数据，放在前端页面展示
    @GetMapping("/success")
    public String success(Map<String , Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("熊亚辉","张三","李四"));
        return "success";
    }

    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }


}
