package com.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/13 16:27
 */

//@Controller
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello World! </h1>";
    }
}
