package com.wusd.mybatisplustest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public MyLocalSqlInject myLocalSqlInject() {
        return new MyLocalSqlInject();
    }
}
