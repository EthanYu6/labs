package com.ysl.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

/**
 * @Author ysl
 * @Date 2020/5/21 11:50
 * @Description:
 **/

@RestController
@RequestMapping("/demo")
public class DemoController {


    @PermitAll
    @GetMapping("/echo")
    public String demo(){
        return "示例返回";
    }


    @GetMapping("/home")
    public String home(){
        return "我是首页";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "我是管理员";
    }


    @PreAuthorize("hasRole('ROLE_NORMAL')")
    @GetMapping("normal")
    public String normal(){
        return "我是普通用户";
    }
}