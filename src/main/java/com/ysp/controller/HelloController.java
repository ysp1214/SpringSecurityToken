package com.ysp.controller;

import com.ysp.domain.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @auther杨甜
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
//    @PreAuthorize("hasAuthority('system:dept:list11111')")
    @PreAuthorize("@yspExpression.hasAuthority('system:dept:list')")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/testCors")
    public ResponseResult testCors(){
        return new ResponseResult(200,"testCors测试成功");
    }
}
