package com.blog.dao;

import com.blog.entity.Myreading;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface MyreadingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Myreading record);

    int insertSelective(Myreading record);

    Myreading selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Myreading record);

    int updateByPrimaryKey(Myreading record);

    List<Myreading> getAllReading();
}
