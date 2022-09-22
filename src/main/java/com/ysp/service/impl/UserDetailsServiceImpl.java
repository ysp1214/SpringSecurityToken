package com.ysp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ysp.domain.LoginUser;
import com.ysp.domain.User;
import com.ysp.mapper.MenuMapper;
import com.ysp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0
 * @auther杨甜
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //加用户名从数据库中查询用户信息
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(wrapper);
        //如果查询不到数据就通过抛出异常来给出提示
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }
        //TODO 根据用户查询权限信息 添加到LoginUser中
//        List<String> list = new ArrayList<>(Arrays.asList("test"));
        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        return new LoginUser(user,list);
    }
}
