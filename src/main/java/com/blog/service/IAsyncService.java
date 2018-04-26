package com.blog.service;

import com.blog.entity.IpLog;
import com.blog.entity.Myreading;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface IAsyncService {
    /**
     * 异步记录ip
     * * @param ipLog
     */
    void insertIpLog(IpLog ipLog);

    /**
     * 异步更新阅读次数
     *
     * @param blogid
     * @return
     */
     void updatebloghits(Integer blogid);

    /**
     * 借书记录
     *
     * @param myreading
     */
     void insertlibrary(Myreading myreading);

     void start();

     void insertMongo(HttpServletRequest request);

    void insertMongo(String key, String value);

    /**
     * 统计耗时
     *
     * @param methodName
     * @param time
     */
     void insertMethodTime(String methodName, Long time);

     Object redisGet(String key, Long liveTime);

     void redisPut(String keyStr, Object valueStr, Long liveTime);
}
