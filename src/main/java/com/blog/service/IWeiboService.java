package com.blog.service;

import com.blog.entity.Weibo;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface IWeiboService {

    public List<Weibo> getAllWeiboToday();

    /**
     * 需要先启动本地的python脚本
     *
     * @param sentence
     * @return
     */
    public JsonObject getWeiboDetail(String sentence);
}
