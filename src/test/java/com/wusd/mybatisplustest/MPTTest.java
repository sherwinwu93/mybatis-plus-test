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

    @Test
    public void testMyInsertAll() {
        SysUser user = new SysUser();
        user.setId(6L);
        user.setName("Wusd");
        user.setAge(3);
        user.setEmail("wsd@foxmail.com");
        userMapper.myInsertAll(user);

        SysUser result = userMapper.selectById(6L);
        System.out.println("------------------------" +  result);
    }
}
