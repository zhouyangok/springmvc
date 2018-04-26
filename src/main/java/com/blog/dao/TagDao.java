package com.blog.dao;

import com.blog.entity.Blog;
import com.blog.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface TagDao {

    int deleteByPrimaryKey(Integer tId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> getTagByBlogId(Integer blogid);

    List<Tag> getAllTags();

    List<Blog> getblogbytagid(Integer tId);

    Tag selectByName(String t_name);
}
