package com.blog.service;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface IMessageService {
    /**
     * 消息队列写入
     *
     * @param routingKey
     * @param message
     */
    void pushToMessageQueue(String routingKey, String message);
}
