package com.ysp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @auther杨甜
 */
@SpringBootApplication
@MapperScan("com.ysp.mapper")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }
}
