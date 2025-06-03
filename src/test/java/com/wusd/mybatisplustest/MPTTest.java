package com.wusd.mybatisplustest;

import com.wusd.mybatisplustest.entity.SysUser;
import com.wusd.mybatisplustest.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MPTApplication.class)
public class MPTTest {
    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void test() {
        SysUser user = userMapper.selectById(1);
        System.out.println("-----------------test...user->" + user);
    }
}
