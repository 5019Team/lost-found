package com.nineteen.lostfound.utils;

/**
 * Created by mengxu on 2018/3/8.
 */
import com.nineteen.lostfound.service.RedisCacheUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 * 监听器，用于项目启动的时候初始化信息
 */
@Service
public class StartCached implements ApplicationListener<ContextRefreshedEvent>
{
    //日志
    private final Logger log= Logger.getLogger(StartCached.class);

    @Autowired
    private RedisCacheUtil<String> redisCache;


    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        //spring 启动的时候缓存城市和国家等信息
        if(event.getApplicationContext().getDisplayName().equals("WebApplicationContext for namespace 'dispatcher-servlet'"))
        {
            System.out.println("\n\n\n_________\n\n缓存数据 \n\n ________\n\n\n\n");
            Map<String,String> cityMap = new HashMap<String, String>();
            Map<String,String> countryMap = new HashMap<String, String>();
            cityMap.put("hello","world");
            countryMap.put("My name is ","mengxu");

            redisCache.setCacheStringMap("cityMap", cityMap);
            redisCache.setCacheStringMap("countryMap", countryMap);
        }
    }
}
