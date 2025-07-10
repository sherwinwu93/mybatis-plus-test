package com.wusd.mybatisplustest.service;

import com.wusd.mybatisplustest.entity.po.ProductProduct;
import com.wusd.mybatisplustest.mapper.ProductProductMapper;
import com.wusd.mybatisplustest.service.IProductProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wusd
 * @since 2025-07-10
 */
@Service
public class ProductProductServiceImpl extends ServiceImpl<ProductProductMapper, ProductProduct> implements IProductProductService {

}
