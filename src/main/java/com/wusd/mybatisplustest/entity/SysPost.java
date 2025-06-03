package com.wusd.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_post")
public class SysPost {
    private Long postId;
    private String postName;
}
