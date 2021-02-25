package com.whole.night.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* lsy
* 2020-2-20
* 该控制器只用于主要页面之间跳转
*/
@Controller
@RequestMapping("/router")
public class WholeNightController {

    @GetMapping("/self")   //路由到个人中心页面
    public String self(){
        return "self";
    }

    @GetMapping("/menu")   //路由到资源列表
    public String menu(){
        return "menu";
    }

    @GetMapping("/login")   //路由到登陆页面
    public String login(){
        return "login";
    }

}
