package com.wusd.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_org")
@Data
public class SysOrg {
    private Long orgId;
    private String orgName;
}
