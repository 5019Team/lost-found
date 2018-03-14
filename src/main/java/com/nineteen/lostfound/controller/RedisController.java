package com.nineteen.lostfound.controller;

import com.nineteen.lostfound.service.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by mengxu on 2018/3/8.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisCacheUtil<String> redisCacheUtil;

    @RequestMapping("/test")
    public void testGetCache() {

        /* Map<String,Country> countryMap = redisCacheUtil1.getCacheMap("country");
           Map<String,City> cityMap = redisCacheUtil.getCacheMap("city");*/
        Map<String, String> countryMap = redisCacheUtil.getCacheStringMap("countryMap");
        Map<String, String> cityMap = redisCacheUtil.getCacheStringMap("cityMap");

        for (String key : countryMap.keySet()) {
            System.out.println("key = " + key + ",value=" + countryMap.get(key));
        }

        System.out.println("------------city");
        for (String key : cityMap.keySet()) {
            System.out.println("key = " + key + ",value=" + cityMap.get(key));
        }
    }
}
