package com.wusd.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`sys_user`")
public class SysUser {
    private Long id;
    private String username;
    private Integer age;
    private String email;
}
