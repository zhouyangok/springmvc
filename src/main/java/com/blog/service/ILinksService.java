package com.blog.service;

import com.blog.entity.Links;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface ILinksService {
    /**
     * 友情链接
     *
     * @return
     */
     List<Links> getAllLinks();
}
