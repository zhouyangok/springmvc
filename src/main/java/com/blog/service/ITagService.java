package com.blog.service;

import com.blog.entity.Tag;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface ITagService {
    public Integer updatetag(Integer tId);

    public List<Tag> getAllTags();

    public void deleteTag(Integer tId) throws RuntimeException;

    public String getBiaoqian() throws Exception;
}
