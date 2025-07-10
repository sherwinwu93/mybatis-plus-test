package com.wusd.mybatisplustest.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wusd
 * @since 2025-07-10
 */
@Getter
@Setter
@ToString
@TableName("sys_org")
@ApiModel(value = "SysOrg对象", description = "")
public class SysOrg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "org_id", type = IdType.AUTO)
    private Long orgId;

    private String orgName;

    private Long parentOrgId;

    private String ancestors;
}
