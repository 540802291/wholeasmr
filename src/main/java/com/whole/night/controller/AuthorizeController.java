package com.whole.night.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*第三方登陆授权*/
@Controller
@RequestMapping("/authorize")
public class AuthorizeController {

    @GetMapping("/qcb")    //qqCallback回调方法
    public void qcb(){

    }
}
