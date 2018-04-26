package com.blog.dao;

import com.blog.entity.Links;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface LinksDao {
    int deleteByPrimaryKey(Integer lid);

    int insert(Links record);

    int insertSelective(Links record);

    Links selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(Links record);

    int updateByPrimaryKey(Links record);

    List<Links> getAllLinks();
}
