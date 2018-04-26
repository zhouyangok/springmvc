package com.blog.service;

import com.blog.entity.Category;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface ICategoryService {

    List<Category> getAllCategory();

    Category selectByPrimaryKey(Integer categoryid);

    List<Category> getAllCatWithoutLife();
}