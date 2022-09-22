package com.ysp;

import com.ysp.mapper.MenuMapper;
import com.ysp.mapper.UserMapper;
import com.ysp.domain.User;
import lombok.ToString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @version 1.0
 * @auther杨甜
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringSercuityTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Test
    public void m1(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void m2(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String ysp = bCryptPasswordEncoder.encode("ysp");
        System.out.println(ysp);
        System.out.println(bCryptPasswordEncoder.matches("ysp", "$2a$10$/r4kCQQneo4IHH8bxDD0Q.9v72IZ4JrIv5k3iRDSwUH/Ru84jAMrq"));
    }
    @Test
    public void m3(){
        List<String> strings = menuMapper.selectPermsByUserId(2L);
        strings.forEach(System.out::println);
    }
}
