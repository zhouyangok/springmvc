package com.blog.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public class Tag implements Serializable {
    private Integer tId;
    private String tName;
    private List<Blog> blogs;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
