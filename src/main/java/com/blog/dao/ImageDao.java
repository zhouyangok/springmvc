package com.blog.dao;

import com.blog.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface ImageDao {
    int deleteByPrimaryKey(Integer imageid);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer imageid);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);

    List<Image> getAllImage();

    int updateiht(Image image);
}
