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

    @GetMapping("/userCenter")   //路由到userCenter页面
    public String userCenter(){
        return "userCenter";
    }

}
