package com.westone.springbootfirstdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author A
 */
@Controller
public class LoginController {

    private static final String PASSWORD = "123456";

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession httpSession){
        if(!StringUtils.isEmpty(username) && PASSWORD.equals(password)){
            //登录成功，要防止重定向，所以可以重定向，不能写掉了/
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名和密码错误");
            return "login";
        }

    }
}
