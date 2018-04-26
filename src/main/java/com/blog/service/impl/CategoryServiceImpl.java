package com.blog.service.impl;

import com.blog.dao.CategoryDao;
import com.blog.entity.Category;
import com.blog.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategory() {
        return null;
    }

    @Override
    public Category selectByPrimaryKey(Integer categoryid) {
        return null;
    }

    @Override
    public List<Category> getAllCatWithoutLife() {
        return null;
    }
}
