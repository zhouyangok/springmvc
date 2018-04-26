package com.blog.service.impl;

import com.blog.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("iMessageService")
public class MessageServiceImpl implements IMessageService {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    public void pushToMessageQueue(String routingKey, String message) {
        System.out.println("成功插入消息 " + message);
    }

    public void popMessage(String destinationQueueName) {
//        Message message = amqpTemplate.receive(destinationQueueName);
        System.out.println("成功取出消息 ");
    }
}