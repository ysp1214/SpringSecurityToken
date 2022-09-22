package com.ysp.controller;

import com.ysp.domain.ResponseResult;
import com.ysp.domain.User;
import com.ysp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @auther杨甜
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }
    @PostMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
