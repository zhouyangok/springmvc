package com.blog.service.impl;

import com.blog.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("logService")
@SuppressWarnings("unchecked")
public class LogServiceImpl implements ILogService {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);
//    private static final String IP = IPUtils.getServerIp();

    @Override
    public void record(String key, String value) {
        System.out.println("hello world");
//        redisTemplate.opsForHash().put("log", key + IP, value + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
    }
}