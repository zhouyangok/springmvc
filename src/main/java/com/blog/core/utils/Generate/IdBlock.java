package com.blog.core.utils.Generate;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public class IdBlock {
    private long nextId;
    private long lastId;

    public IdBlock(long nextId, long lastId) {
        this.nextId = nextId;
        this.lastId = lastId;
    }

    public long getNextId() {
        return nextId;
    }

    public long getLastId() {
        return lastId;
    }
}

