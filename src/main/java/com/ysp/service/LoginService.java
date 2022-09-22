package com.ysp.service;

import com.ysp.domain.ResponseResult;
import com.ysp.domain.User;

/**
 * @version 1.0
 * @auther杨甜
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
