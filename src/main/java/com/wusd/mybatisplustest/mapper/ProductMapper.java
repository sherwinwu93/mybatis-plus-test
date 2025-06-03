package com.wusd.mybatisplustest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wusd.mybatisplustest.datapermission.DataPermission;
import com.wusd.mybatisplustest.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {

    @DataPermission
    @Select("select * from product_product")
    List<Product> queryAll();
}
