package com.blog.dao;

import com.blog.entity.Relation;
import com.blog.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface RelationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Relation record);

    int insertSelective(Relation record);

    Relation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);

    List<Relation> getBlogByTagId(Integer tag_id);

    Relation gettagidbyblogid(Integer blogid);

    Tag getTagByBlogId(Integer blogid);
}

