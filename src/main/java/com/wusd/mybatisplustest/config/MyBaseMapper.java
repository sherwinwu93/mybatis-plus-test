package com.wusd.mybatisplustest.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    int myInsertAll(T entity);
}
