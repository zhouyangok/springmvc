package com.blog.entity;

import java.io.Serializable;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public class KeyAndValue implements Serializable {
    private String key;
    private String value;

    public KeyAndValue() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
