package com.blog.service.impl;

import com.blog.dao.BlogDao;
import com.blog.dao.TagDao;
import com.blog.entity.Blog;
import com.blog.entity.Category;
import com.blog.entity.Tag;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("blogService")
public class BlogServiceImpl implements IBlogService {

    private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Resource
    private BlogDao blogDao;
    @Resource
    private ICategoryService categoryService;
    @Resource
    private TagDao tagDao;

    private static void ssubSet(Set<String> obSet, int size){
        if(CollectionUtils.isEmpty(obSet)){
            Collections.emptySet();
        }
        ImmutableSet.copyOf(Iterables.limit(obSet,size));
    }

    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = blogDao.getAllBlog();
        for (Blog blog : blogs) {
            blog.setCategory(categoryService.selectByPrimaryKey(blog.getCategoryid()));
        }
        return blogs;
    }

    @Override
    public List<Blog> getByCategoryId(int categoryid) {
        List<Blog> blogs = blogDao.getByCategoryId(categoryid);
        return blogs;
    }

    @Override
    public Blog getBlogDetail(Integer blogid) {
        Blog blog = blogDao.selectByPrimaryKey(blogid);
        if (blog == null) {
            return null;
        }
        Category category = categoryService.selectByPrimaryKey(blog.getCategoryid());
        blog.setCategory(category);
        List<Tag> tags = tagDao.getTagByBlogId(blog.getBlogid());
        blog.setTags(tags.size() > 0 ? tags : null);
        logger.info("没有走缓存");
        return blog;
    }

    @Override
    public Tag getTagByTid(Integer t_id) {
        return null;
    }

    @Override
    public List<Blog> getBlogByTagId(Integer tId) {
        return null;
    }

    @Override
    public List<Blog> getBanner() {
        return null;
    }

    @Override
    public List<Blog> getByHits() {
        return null;
    }

    @Override
    public List<Blog> getLife() {
        return null;
    }

    @Override
    public List<Blog> getAllTechBlog() {
        return null;
    }

    @Override
    public List<Blog> getLuceneBlog(Integer pageStart, String keyword, Integer pagehits) {
        return null;
    }

    @Override
    public void ajaxbuild() {

    }

    @Override
    public Set<String> ajaxsearch(String keyword) {
        return null;
    }

    @Override
    public List<Blog> getAllBlogWithContent() {
        return null;
    }

    @Override
    public Blog preBlog(Integer blogId) {
        return null;
    }

    @Override
    public Blog nextBlog(Integer blogId) {
        return null;
    }
}
