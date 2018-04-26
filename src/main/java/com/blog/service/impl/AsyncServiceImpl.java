package com.blog.service.impl;

import com.blog.core.utils.LibraryUtil;
import com.blog.dao.BlogDao;
import com.blog.dao.IpLogDao;
import com.blog.dao.MyreadingDao;
import com.blog.entity.IpLog;
import com.blog.entity.Myreading;
import com.blog.service.IAsyncService;
import com.blog.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public class AsyncServiceImpl implements IAsyncService {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Resource
    private IpLogDao ipLogDao;
    @Resource
    private BlogDao blogDao;
    @Resource
    private IMessageService messageService;
    @Resource
    private MyreadingDao myreadingDao;
    @Resource
    private RedisTemplate redisTemplate;

    @Async
    @Override
    public void insertIpLog(IpLog ipLog) {
        try {
            messageService.pushToMessageQueue("rabbit_queue_one", ipLog.toString());
            ipLogDao.insertSelective(ipLog);      //记录每一条日志
        } catch (Exception e) {
            logger.error("ip插入错误", e);
        }
    }

    @Async
    @Override
    public void updatebloghits(Integer blogid) {
        try {
            blogDao.updatehits(blogid);
        } catch (Exception e) {
            logger.error("更新阅读次数错误", e);
        }
    }

    @Async
    @Override
    public void start() {
        List<Myreading> list = LibraryUtil.htmltoJavaBean();
        for (Myreading myreading : list) {
            myreadingDao.insertSelective(myreading);
        }
        logger.info("start");
    }

    @Async
    @Override
    public void insertlibrary(Myreading myreading) {
        try {
            myreadingDao.insert(myreading);
        } catch (Exception e) {
            logger.error("借阅错误", e);
        }
    }

    @Async
    @Override
    public void insertMongo(HttpServletRequest request) {
        System.out.println("{\"name\":\"菜鸟教程\"}");
    }

    @Async
    @Override
    public void insertMongo(String key, String value) {

        System.out.println("{\"name\":\"菜鸟教程\"}");
    }

    @Async
    @Override
    @SuppressWarnings("unchecked")
    public void insertMethodTime(String methodName, Long time) {
        redisTemplate.opsForHash().put("method", methodName, time);
    }

    @Async
    @Override
    public Object redisGet(String key,Long liveTime) {
        byte[] key1 = key.getBytes();
        return redisTemplate.execute(connection -> {
            byte[] value1 = connection.get(key1);
            if (value1 == null) {
                return null;
            }
            // 每次获得延迟时间
            if (liveTime > 0) {
                connection.expire(key1, liveTime);
            }
            return toObject(value1);
        }, true);
    }

    @Async
    @Override
    public void redisPut(String keyStr,Object valueStr,Long liveTime){
        redisTemplate.execute(connection -> {
            byte[] keyb = keyStr.getBytes();
            byte[] valueb = toByteArray(valueStr);
            connection.set(keyb, valueb);
            if (liveTime > 0) {
                connection.expire(keyb, liveTime);
            }
            return 1L;
        }, true);
    }


    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }
    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }
}
