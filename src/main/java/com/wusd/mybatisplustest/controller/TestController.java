package com.wusd.mybatisplustest.controller;


import com.wusd.mybatisplustest.entity.Product;
import com.wusd.mybatisplustest.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ProductMapper mapper;
    @GetMapping
    public ResponseEntity test() {
        Product product = mapper.selectById(1L);
        Product o = new Product();
        o.setProductId(product.getProductId());
        o.setCreator("wusd2");
        mapper.updateById(o);
        return ResponseEntity.ok(o);
    }
}
