package com.wusd.mybatisplustest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wusd.mybatisplustest")
public class MPTApplication {
    public static void main(String[] args) {
        SpringApplication.run(MPTApplication.class, args);
    }
}
