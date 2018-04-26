package com.blog.dao;

import com.blog.entity.Weibo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface WeiboDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    Weibo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKeyWithBLOBs(Weibo record);

    int updateByPrimaryKey(Weibo record);

    List<Weibo> getAllWeiboToday();
}
