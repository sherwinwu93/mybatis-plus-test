package com.wusd.mybatisplustest.controller;

import com.wusd.mybatisplustest.config.MybatisPlusConfig;
import com.wusd.mybatisplustest.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/orgPost")
public class OrgPostController {

    @PutMapping
    public ResponseEntity put(String key, @RequestParam("value") String value)  {
        MapUtils.orgPost.put(key, value);
        return ResponseEntity.ok().build();
    }
}
