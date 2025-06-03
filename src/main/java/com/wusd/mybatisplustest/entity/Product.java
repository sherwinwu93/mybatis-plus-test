package com.wusd.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_product")
public class Product {
    private Long productId;
    private String productName;
    private Long orgId;
    private Long postId;
    private String creator;
}
