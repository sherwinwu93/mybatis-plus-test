package com.wusd.mybatisplustest.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.wusd.mybatisplustest.datapermission.DataPermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public MyLocalSqlInject myLocalSqlInject() {
        return new MyLocalSqlInject();
    }

    @Bean
    public DataPermissionInterceptor dataPermissionInterceptor() {
        return new DataPermissionInterceptor();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(dataPermissionInterceptor());
        return interceptor;
    }
}
