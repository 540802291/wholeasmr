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

    @GetMapping("/center")   //路由到个人中心页面
    public String self(){
        return "center";
    }

    @GetMapping("/menu")   //路由到资源列表
    public String menu(){
        return "menu";
    }

}
