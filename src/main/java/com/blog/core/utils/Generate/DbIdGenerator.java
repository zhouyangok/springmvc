package com.blog.core.utils.Generate;

import org.springframework.stereotype.Component;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Component("dbIdGenerator")
public class DbIdGenerator {

    private int idBlockSize = 1;
    private long nextId = 0;
    private long lastId = -1;

    public synchronized Long getNextId() {
        if (lastId < nextId) {
            getNewBlock();
        }
        return (nextId++);
    }

    private synchronized void getNewBlock() {
        IdBlock idBlock = new IdBlock(100,200);
        this.nextId = idBlock.getNextId();
        this.lastId = idBlock.getLastId();
    }
}
